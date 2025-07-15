package cce.ruleupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.json.JSONObject;

import binpack.FFD;

public class CCE{
	
	public static void main(String[] args) {
		try {
			// read and load all YML rules, setting them to SigmaMapping data.
			ArrayList<SigmaMapping> sigmaMappingArray = Load_YML_Rules.loadRules();
			// delete current Lambdas...
			File configFolder = new File("devices/config/"); // YML config files
			File[] configDevices = configFolder.listFiles();
			if (configDevices.length > 0) {
				for (File configDevice : configDevices) {
					List<String> configDeviceLines = Files.readAllLines(configDevice.toPath());
					for (String line : configDeviceLines) {
						if (line.startsWith("bin:")) {
							String binName = line.substring(4);
							binName = binName.trim();
							LambdaDelete.callDelete(binName);
						}
					}
				}
			}
			LambdaDelete.callDelete("correlation");
			
			// Setting variables defined by the user.
			File cceConf = new File("CCE.conf");
			List<String> cceConfLines = Files.readAllLines(cceConf.toPath());
			
			String[] temp = cceConfLines.get(0).split(":");
			int runfor = Integer.parseInt(temp[1].trim());
			temp = cceConfLines.get(1).split(":");
			String lambda_memsize = temp[1].trim();
			temp = cceConfLines.get(2).split(":");
			int bincap = Integer.parseInt(temp[1].trim());
			//temp = cceConfLines.get(3).split(":");
			int triggerGap = Integer.parseInt(temp[1].trim());
			
			
			// separate and organize the rule conditions by device, as well as the correlation rules.
			LinkedHashMap<String, Rule_Condition_Data> ruleCondProductArray = 
					Rule_Condition_Config.setCondRules(sigmaMappingArray, triggerGap);
			
			// generate the code for the rule conditions by product and the correlation rules.
			Rule_Condition_GenCode.generateCondCode(ruleCondProductArray);
			LinkedHashMap<String, ArrayList<String>> verifVars = Rule_Condition_GenCode.getVerifVars();
			LinkedHashMap<String, ArrayList<String>> verifCodes = Rule_Condition_GenCode.getVerifCodes();
			LinkedHashMap<String, ArrayList<String>> condCodes = Rule_Condition_GenCode.getCondCodes();
						
			// get the names and the estimated time costs to execute the bin packing algorithm.
			Integer binItems[] = new Integer[ruleCondProductArray.size()-1];
			ArrayList<BPdata> bpData = new ArrayList<BPdata>();
			
			//Only to test the performance with one device per bin/lambda. comment oneDevPerBin to use BinPacking.
			//ArrayList<ArrayList<String>> oneDevPerBin = new ArrayList<ArrayList<String>>();
			int count = 0;
			for (Map.Entry<String, Rule_Condition_Data> prodCond : ruleCondProductArray.entrySet()) {
				if (!prodCond.getKey().equals("correlationRules")) {
					binItems[count] = prodCond.getValue().cost_bincap;
					bpData.add(new BPdata(prodCond.getValue().cost_bincap, prodCond.getValue().productName));
					//ArrayList<String> tempArray = new ArrayList<String>();
					//tempArray.add(prodCond.getValue().productName);
					//oneDevPerBin.add(tempArray);
					count++;
				}
			}
						
			ArrayList<ArrayList<String>> bins = FFD.firstFitDec(binItems, bpData, bincap);
			
			//Delete old code from correlation lambda.
			Bins_DeployCode.deleteFiles(new File("rule_template_code/correlation"));
			
			// generate the code for the correlation rule (stateful lambda)
			Bins_DeployCode.generateRuleCodeFromTemplate("correlation", "statefull-lambda-archetype");
			Bins_DeployCode.injectRuleCode(
					verifVars.get("correlationRules"), 
					verifCodes.get("correlationRules"), 
					condCodes.get("correlationRules"), 
					"correlation");
			Bins_DeployCode.deployLambdaRule("rule_template_code/correlation", "correlation", lambda_memsize);
			
			//Delete events
			// If you comment these two lines, the generated events are not deleted.
			Bins_DeployCode.deleteFiles(new File("events/"));
			Files.createDirectory(Paths.get("events"));
			
			// create a hash name for each bin (stateless condition rules)
			//for (ArrayList<String> bin : oneDevPerBin) {
			for (ArrayList<String> bin : bins) {
				ArrayList<String> verifVar = new ArrayList<String>();
				ArrayList<String> verifCode = new ArrayList<String>();
				ArrayList<String> condCode = new ArrayList<String>();
				
				String hash = Rule_Condition_Config.getHash(bin.toString().getBytes());
				hash = "_"+hash;
				
				//Delete old version of this lambda.
				Bins_DeployCode.deleteFiles(new File("rule_template_code/"+hash));

				// generate the code for each rule (stateless lambda)
				Bins_DeployCode.generateRuleCodeFromTemplate(hash, "stateless-lambda-archetype");
				for (String binItem : bin) {
					verifVar.addAll(verifVars.get(binItem));
					verifCode.addAll(verifCodes.get(binItem));
					condCode.addAll(condCodes.get(binItem));
					Rule_Condition_Config.setDeviceBin(binItem, hash);
					ruleCondProductArray.get(binItem).bin = hash;
				}
				Bins_DeployCode.injectRuleCode(verifVar, verifCode, condCode, hash);
				Bins_DeployCode.deployLambdaRule("rule_template_code/"+hash, hash, lambda_memsize);
			}
			Thread.sleep(10000); // Wait a moment for Lambdas deployment complete and turn them available.
			
			//for (ArrayList<String> bin : oneDevPerBin) {
			for (ArrayList<String> bin : bins) {
				String hash = Rule_Condition_Config.getHash(bin.toString().getBytes());
				hash = "_"+hash;
				Bins_DeployCode.updateLambdaConfig(hash);
				System.out.println("Updating environment variable of Lambda "+hash);
			}
			Bins_DeployCode.updateLambdaConfig("correlation");
			System.out.println("Updating environment variable of Lambda correlation");
			
			Rule_Condition_Config.writeConfigDevicesToFile(ruleCondProductArray);
			
			// Starting the producers and consumers...
			HashMap<String, ArrayList<BlockingQueue<JSONObject>>> binsBlockingQueue = new HashMap<String, ArrayList<BlockingQueue<JSONObject>>>();
			
			String evtEmpty = "{\"eventid\": "+9999+", \"src_ip\": \"10.0.0.1\", \"dst_ip\": \"10.0.0.1\", \"dvchost\": "
					+ "\"10.0.0.1\", \"dvc\": \"10.0.0.1\", \"dhost\": \"10.0.0.1\", \"msg\": \"Warming Lambda\", "
					+ "\"duser\": \"any\", \"rt\": \"whatever\"}";
			
			for (Map.Entry<String, Rule_Condition_Data> ruleCondProductEntry : ruleCondProductArray.entrySet()) {
				String key = ruleCondProductEntry.getKey();
				Rule_Condition_Data value = ruleCondProductEntry.getValue();
				
				if (!key.equals("correlationRules")) {
					if (binsBlockingQueue.get(value.bin) == null) {
						binsBlockingQueue.put(value.bin, new ArrayList<BlockingQueue<JSONObject>>());
					}
					binsBlockingQueue.get(value.bin).add(value.queue);
				}
			}
			// Starts the consumers (of events)
			for (Map.Entry<String, ArrayList<BlockingQueue<JSONObject>>> binBlockingQueue : binsBlockingQueue.entrySet()) {
				String key = binBlockingQueue.getKey();
				ArrayList<BlockingQueue<JSONObject>> value = binBlockingQueue.getValue();
				Thread lambdaWarming = new Thread(new LambdaTrigger(key, evtEmpty, 1, 0, 1));
				lambdaWarming.start();
				System.out.println("Triggering a warming lambda for: "+ key);
			}
			for (Map.Entry<String, ArrayList<BlockingQueue<JSONObject>>> binBlockingQueue : binsBlockingQueue.entrySet()) {
				String key = binBlockingQueue.getKey();
				ArrayList<BlockingQueue<JSONObject>> value = binBlockingQueue.getValue();
				Thread thread = new Thread(new DataConsumer(key, value, triggerGap, runfor));
				System.out.println("Starting bin consumer: " + key);
				thread.start();
			}
			
			Thread.sleep(bincap*2); // Wait a moment for warming up all Detection Lambdas.
			
			// Starts the producers (of events)
			for (Map.Entry<String, Rule_Condition_Data> ruleCondProductEntry : ruleCondProductArray.entrySet()) {
				String key = ruleCondProductEntry.getKey();
				Rule_Condition_Data value = ruleCondProductEntry.getValue();
				
				if (!key.equals("correlationRules")) {
					Thread thread = new Thread(new DataProducer(key, value.queue, value.eps, runfor));
					System.out.println("Starting dev producer: " + key + " to bin " + value.bin);
					thread.start();
				}
			}
			
			//boolean fin = true;
			long starttime = System.currentTimeMillis();
			int triggerCount=0;
			while(System.currentTimeMillis() - starttime < runfor) {
				triggerCount++;
				Thread thread = new Thread(new LambdaTriggerCorrelation("correlation", triggerGap, triggerCount));
				thread.start();
				Thread.sleep(triggerGap);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package old;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class GenRule {

	static LinkedHashMap<Integer, String[]> datasetEntries;
	
	public static void main(String args[]) {
		//GenRule.loadDataset();
		//GenRule.ruleCreation();
		//GenRule.createCorrRule();
		ArrayList<RuleFields> ruleFields = new ArrayList<GenRule.RuleFields>();
		
		try {
			Path datasetPath = Paths.get("rulessource.txt");
			List<String> datasetLines = Files.readAllLines(datasetPath);
			for (int i = 0; i < datasetLines.size(); i++) {
				String[] dsline = datasetLines.get(i).split("-");
				RuleFields rl = new RuleFields();
				rl.product = dsline[0];
				rl.service = dsline[1];
				rl.field = dsline[2];
				rl.value = dsline[3];
				ruleFields.add(rl);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (RuleFields rl : ruleFields) {
			createFilterRule(rl);
		}
	}
	
	static class RuleFields{
		String product;
		String service;
		String field;
		String value; 
	}
	
	private static void loadDataset() {
		try {
			Path datasetPath = Paths.get("dataset.csv");
			List<String> datasetLines = Files.readAllLines(datasetPath);
			datasetEntries = new LinkedHashMap<Integer, String[]>();
			for (int i = 0; i < datasetLines.size(); i++) {
				String[] dsline = datasetLines.get(i).split(",");			
				datasetEntries.put(Integer.valueOf(dsline[0]), dsline);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ruleCreation() {
		int[] blockSize =     {100,200,400,800,1600,3000};
		int[] verifications = {10,50,200,500,1000};
		int[] dbInserts =     {0,1,2,5,10};
		int[] memSize =       {1024}; //{512, 1024, 1792, 3008};
		
		for (int m = 0; m < memSize.length; m++) {
			for (int i = 0; i < blockSize.length; i++) {
				for (int j = 0; j < verifications.length; j++) {
					for (int x = 0; x < dbInserts.length; x++) {
						int selCount = 0;
						int verifCount = 0;
						String selection="";
						String condition="";
						String newRuleName = "cce" + blockSize[i] + "_" + verifications[j] + "_" + dbInserts[x] + "_" + memSize[m];
						//int insert = (blockSize[i] * dbInserts[x]) / 100;  // verifications that match and trigger a DB insert
						int insert = dbInserts[x];
						int noinsert = verifications[j] - insert; // verifications that doesn't match
						String value="";
						selection = "  selection0:\n    src_ip:";
						condition = "  condition: selection0";
						
						for (int k = 0; k < noinsert; k++) {
							if (verifCount>=10) { // this limit is because an if can be to large...
								verifCount = 0;
								selCount++;
								selection += "\n  selection"+selCount+":\n    src_ip:";
								condition += " or selection"+selCount;
							}
							int rand = new Random().nextInt(blockSize[i]);
							String[] entry = datasetEntries.get(rand+1);
							value = entry[2];
							selection += "\n      - '"+value+"'";
							verifCount++;
						}
						for (int k = 0; k < insert; k++) {
							if (verifCount>=10) { // this limit is because an if can be to large...
								verifCount = 0;
								selCount++;
								selection += "\n  selection"+selCount+":\n    src_ip:";
								condition += " or selection"+selCount;
							}
							//int rand = new Random().nextInt(blockSize[i]);
							int rand = new Random().nextInt(100);
							String[] entry = datasetEntries.get(rand+1);
							value = entry[1];
							selection += "\n      - '"+value+"'";
							verifCount++;
						}
						ruleInjection(selection, condition, newRuleName);
					}
				}
			}
		}
	}
	
	private static void ruleInjection(String selection, String condition, String newRuleName) {
		try {
			// Project path
			Path ruleTemplate = Paths.get("rule.yml");
			// 
			Path newRulePath = Paths.get("0cce_rules/" + newRuleName + "/" + newRuleName + ".yml");
			File dir = new File("cce_rules/" + newRuleName);
			dir.mkdir();
			List<String> ruleLines = Files.readAllLines(ruleTemplate);
			String newRule = new String();
			for (int i = 0; i < ruleLines.size(); i++) {
				String tmp = ruleLines.get(i);
				if (tmp.contains("xxxxxx")) {
					ruleLines.set(i, selection);
				} else if (tmp.contains("yyyyyy")) {
					ruleLines.set(i, condition);
				} 
				newRule += ruleLines.get(i) + "\n";
			}

			byte[] peB = newRule.getBytes();
			Files.write(newRulePath, peB, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createCorrRule() {
		String[] dev = {
	    		"firewall.ciscoasa", 
	    		"firewall.sonicwall", 
	    		"proxy.squid", 
	    		"ids.snort", 
	    		"sgbd.mysql",
	    		"sgbd.postgresql",
	    		"webserver.php"};

		for (int count = 1; count <= 50; count++) {
			int rdm = new Random().nextInt(256);
			String dev1 = dev[new Random().nextInt(7)];
			String dev2 = dev[new Random().nextInt(7)];
			String dev3 = dev[new Random().nextInt(7)];
			String corr = "title: Correlation rule test number "+count + "\n"
					+ "type: Correlation" + "\n"
					+ "id: 12345678-abcd-1234-abcd-123456789x"+count + "\n"
					+ "description: Correlation rule created to test CCE engine - "+count + "\n"
					+ "references:" + "\n"
					+ "    - https://google.com/123456789x"+count + "\n"
					+ "status: experimental" + "\n"
					+ "author: 'Adriano Serckumecka'" + "\n"
					+ "logsource:"+"\n"
					+ "    category: many" + "\n"
					+ "    product: many" + "\n"
					+ "detection:" + "\n"
					+ "    "+dev1+".src_ip: '192.168."+rdm+".*'" + "\n"
					+ "    "+dev2+".duser: 'duser"+rdm+"'" + "\n"
					+ "    "+dev3+".dhost: 'dhost"+rdm+"'" + "\n"
					+ "    condition: "+dev1+".src_ip and "+dev2+".duser and "+dev3+".dhost" + "\n"
					+ "timeframe: 60m" + "\n"
					+ "falsepositives:" + "\n"
					+ "    - unknown" + "\n"
					+ "level: high";
			Path rulePath = Paths.get("rules_yml/CR"+count+".yml");
			byte[] peB = corr.getBytes();
			try {
				Files.write(rulePath, peB, StandardOpenOption.CREATE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void createFilterRule(RuleFields rl) {
		int count = new Random().nextInt(1000);	
		String corr = "title: filter-rule_"+rl.product+"_"+rl.service+"_"+count + "\n"
				+ "type: Filter" + "\n"
				+ "id: 12345678-abcd-1234-abcd-123456789x"+count + "\n"
				+ "description: filter-rule_"+rl.product+"_"+rl.service+"_"+count + "\n"
				+ "references:" + "\n"
				+ "    - https://google.com/123456789x"+count + "\n"
				+ "status: experimental" + "\n"
				+ "author: 'Adriano Serckumecka'" + "\n"
				+ "logsource:"+"\n"
				+ "    product: "+rl.product+ "\n"
				+ "    service: "+rl.service+ "\n"
				+ "detection:" + "\n"
				+ "  selection:" + "\n"
				+ "    "+rl.field+": '"+rl.value+"'" + "\n"
				+ "    condition: selection" + "\n"
				+ "falsepositives:" + "\n"
				+ "    - unknown" + "\n"
				+ "level: high";
		Path rulePath = Paths.get("ccerules/filter-rule_"+rl.product+"_"+rl.service+"_"+count+".yml");
		byte[] peB = corr.getBytes();
		try {
			Files.write(rulePath, peB, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

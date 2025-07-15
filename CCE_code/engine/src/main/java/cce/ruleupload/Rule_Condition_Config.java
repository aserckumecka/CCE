package cce.ruleupload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.yaml.snakeyaml.Yaml;

public class Rule_Condition_Config {
	static ArrayList<String[]> prodDataFromFileV = new ArrayList<String[]>();
	static LinkedHashMap<String, Rule_Condition_Data> productCondArray;
	static int triggerGap=0;

	public static LinkedHashMap<String, Rule_Condition_Data> setCondRules(ArrayList<SigmaMapping> sigmaMappingArray, int tgap) {
		// createProductConditionsArray();
		triggerGap = tgap;
		readConfigDevices();
		for (SigmaMapping sigmaMapping : sigmaMappingArray) {
			String timeframe = sigmaMapping.getTimeframe();
			String condition = sigmaMapping.getCondition();
			String severity = sigmaMapping.getLevel();
			String productName = null;

			for (Map.Entry<String, LinkedHashMap<String, Object>> LHMdetection : sigmaMapping.getDetection().entrySet()) {
				String key = LHMdetection.getKey(); 
				Object value = LHMdetection.getValue();

				String internalName = null;
				if (value.getClass() == LinkedHashMap.class) {
					LinkedHashMap<String, Object> valueLHM = (LinkedHashMap<String, Object>) value;

					for (Entry<String, Object> entry : valueLHM.entrySet()) {
						internalName = entry.getKey();
						break;
					}
				}else {
					internalName = key;
				}
				String[] productNameSplit = internalName.split("\\.");
				productName = productNameSplit[0] + "." + productNameSplit[1];

				byte[] valueByteArray = null;
				try {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					ObjectOutputStream os = new ObjectOutputStream(out);
					os.writeObject(LHMdetection.getKey() + LHMdetection.getValue());
					valueByteArray = out.toByteArray();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (!key.isBlank()) {
					// generate hash to use as key and identifier.
					String hash = getHash(valueByteArray);
					hash = "_" + hash;
					condition = condition.replace(key, hash);
					productCondArray.get(productName).ruleConditionsLHM.put(hash, LHMdetection);

					if (!timeframe.equals("null")) {
						// stateful
						productCondArray.get(productName).conditionRegex.add(new String[] { hash, "Alert" });
						// }else {
						// stateless
					}
				} else
					System.out.println("There is no device named: " + LHMdetection.getKey());
			} // end of detection items...
			if (timeframe.equals("null")) {
				productCondArray.get(productName).conditionRegex
						.add(new String[] { condition, "Alarm", sigmaMapping.getId(), sigmaMapping.toJson(), severity});
			} else
				productCondArray.get("correlationRules").conditionRegex.add(
						new String[] { condition, "Alarm", sigmaMapping.getId(), sigmaMapping.toJson(), timeframe, severity});

		} // end of sigma mapping item...
		countVerifications();
		writeConfigDevicesToFile(productCondArray);
		/*
		 * // Prints only...
		 * ################################################################# for
		 * (Map.Entry<String, Rule_Condition_Data> prodcond :
		 * productCondArray.entrySet()) { System.out.println(prodcond.getKey());
		 * System.out.println(prodcond.getValue().conditionRulesMap.toString());
		 * System.out.println(prodcond.getValue().countVerifications);
		 * ArrayList<String[]> array = prodcond.getValue().conditionRegex; for(int i =
		 * 0; i < array.size(); i++){ System.out.println(array.get(i)[0]);
		 * System.out.println(array.get(i)[1]); //System.out.println(array.get(i)[2]);
		 * //System.out.println(array.get(i)[3]); } System.out.println("\n"); }
		 */
		return productCondArray;
	}

	private static void createProductConditionsArray() {
		try {
			Path devices = Paths.get("devices.txt");
			List<String> prodDataFromFile = Files.readAllLines(devices);
			productCondArray = new LinkedHashMap<String, Rule_Condition_Data>();

			for (int i = 0; i < prodDataFromFile.size(); i++) {
				prodDataFromFileV.add(prodDataFromFile.get(i).split(","));
				productCondArray.put(prodDataFromFileV.get(i)[0], new Rule_Condition_Data(prodDataFromFileV.get(i)));
			}
			productCondArray.put("correlationRules",
					new Rule_Condition_Data(new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readConfigDevices() {
		productCondArray = new LinkedHashMap<String, Rule_Condition_Data>();
		Yaml yaml = new Yaml();
		// String projectPath = System.getProperty("user.dir");
		File configFolder = new File("devices/config/"); // YML config files
		if (!configFolder.exists()) {
			configFolder.mkdir();
		}
		File[] yml_config = configFolder.listFiles();
		if (yml_config.length > 0) {
			for (int j = 0; j < yml_config.length; j++) {
				System.out.println(yml_config[j].toString());
				try {
					InputStream inputStream = new FileInputStream(yml_config[j]);
					Reader reader = new InputStreamReader(inputStream);
					LinkedHashMap<String, Object> yamlConfigObj = yaml.load(reader);// from yaml file.
					Rule_Condition_Data rcd = new Rule_Condition_Data();
					rcd.triggerGap = triggerGap;
					rcd.eps = (int) yamlConfigObj.get("eps");
					//rcd.eps = rcd.eps * (triggerGap / 1000);
					rcd.ins = Double.parseDouble(yamlConfigObj.get("ins").toString());
					rcd.bin = String.valueOf(yamlConfigObj.get("bin"));
					rcd.ver = (int) yamlConfigObj.get("ver");
					rcd.epsR = Float.parseFloat(yamlConfigObj.get("epsR").toString());
					rcd.verR = Float.parseFloat(yamlConfigObj.get("verR").toString());
					rcd.insR = Float.parseFloat(yamlConfigObj.get("insR").toString());
					rcd.conR = Float.parseFloat(yamlConfigObj.get("conR").toString());
					rcd.productName = String.valueOf(yamlConfigObj.get("devname"));
					// ArrayList<Integer> ins_values = (ArrayList<Integer>)
					// yamlConfigObj.get("ins_values");
					// ArrayList<Integer> eps_values = (ArrayList<Integer>)
					// yamlConfigObj.get("eps_values");
					/*
					 * int total = 0; for(int i=0; i<eps_values.size(); i++) {
					 * total=total+eps_values.get(i); } rcd.eps = total/eps_values.size(); total =
					 * 0;
					 * 
					 * for(int i=0; i<ins_values.size(); i++) { total=total+ins_values.get(i); }
					 * rcd.ins = total/ins_values.size();
					 */
					rcd.calculateCost();
					productCondArray.put(rcd.productName, rcd);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			productCondArray.put("correlationRules", new Rule_Condition_Data());
		}
	}

	private static void countVerifications() {
		for (Map.Entry<String, Rule_Condition_Data> prodcond : productCondArray.entrySet()) {
			int numVerifications = prodcond.getValue().ruleConditionsLHM.toString().split(",").length;
			ArrayList<String[]> array = prodcond.getValue().conditionRegex;
			for (int i = 0; i < array.size(); i++) {
				String temp = array.get(i)[0].replace(" or ", " and ");
				String nver[] = temp.split(" and ");
				numVerifications = numVerifications + nver.length;
			}
			// int verifications = productCondArray.get(prodcond.getKey()).ver;
			productCondArray.get(prodcond.getKey()).ver = numVerifications;
			// int posProdCond = 0;
			// for (int i=0; i < prodDataFromFileV.size(); i++) {
			// if (prodDataFromFileV.get(i)[0].equals(prodcond.getKey())) {
			// prodDataFromFileV.get(i)[2] = String.valueOf(numVerifications);
			// posProdCond = i;
			// break;
			// }
			// }
			productCondArray.get(prodcond.getKey()).calculateCost();
			// String cost = String.valueOf(productCondArray.get(prodcond.getKey()).cost);
			// if (!prodcond.getKey().equals("correlationRules")) {
			// prodDataFromFileV.get(posProdCond)[8] = cost;
			// }
		}
	}

	public static void writeConfigDevicesToFile(LinkedHashMap<String, Rule_Condition_Data> productCondArray){
		File configFolder = new File("devices/config/"); // YML config files
		if (!configFolder.exists()) {
			configFolder.mkdir();
		}
		
		for (Map.Entry<String, Rule_Condition_Data> device : productCondArray.entrySet()) {
			if(!device.getKey().equals("correlationRules")) {
				String productName = device.getValue().productName;
				
				String ins = new String();
				File ins_dir = new File("devices/ins/");
				File ins_files[] = ins_dir.listFiles();
				
				String eps = new String();
				//File eps_dir = new File("devices/eps/");
				//File eps_files[] = eps_dir.listFiles();
				
				try {
					if (ins_files.length > 0) {
						Path dev_ins = Paths.get("devices/ins/"+productName);
						List<String> devInsLines;
						
						devInsLines = Files.readAllLines(dev_ins);
						
						double insInt = 0;
						int position = 0;
						
						if (devInsLines.size()>0){
							if (devInsLines.size()>500) {
								position = devInsLines.size()-500;
							}else {
								position = 0;
							}
							
							//inserts...
							Object newArray[] = Arrays.copyOfRange(devInsLines.toArray(), position, devInsLines.size()-1);
							for (Object object : newArray) {
								insInt += Double.parseDouble(String.valueOf(object));
							}
							insInt = insInt / newArray.length;
							ins = String.valueOf((int)insInt);
							
							//eps - events per second...
							Path dev_eps = Paths.get("devices/eps/"+productName);
							List<String> devEpsLines = Files.readAllLines(dev_eps);
							double epsInt = 0;
							
							Object newArray2[] = Arrays.copyOfRange(devEpsLines.toArray(), position, devEpsLines.size()-1);
							for (Object object : newArray2) {
								epsInt += Double.parseDouble(String.valueOf(object));
							}
							epsInt = epsInt / newArray2.length;
							eps = String.valueOf((int)epsInt);
							
						}else {
							ins = String.valueOf(device.getValue().ins);
							eps = String.valueOf(device.getValue().eps);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				device.getValue().calculateCost();
				System.out.println(device.getKey() + " | cost =>" +  device.getValue().cost);
				System.out.println(device.getKey() + " | cost_bincap =>" +  device.getValue().cost_bincap);
				
				String output = "# VARIABLES USED TO IDENTIFY AND CALCULATE THE COST TO PROCESS A DEVICE RULES.\n"
						+ "\n"
						+ "# Category/Manufacturer and Device Name (It will form a unique identifier for this device).\n"
						+ "devname: "+device.getValue().productName+"\n"
						+ "\n"
						+ "# Events per second (average).\n"
						+ "eps: "+eps+"\n"
						+ "\n"
						+ "# Number of verifications associated to this device.\n"
						+ "ver: "+device.getValue().ver+"\n"
						+ "\n"
						+ "# Percentage of DB inserts according to the number of EPS (average).\n"
						+ "ins: "+ins+"\n"
						+ "\n"
						+ "# These four values are calculated using power regression and used to estimate the cost value.\n"
						+ "epsR: "+device.getValue().epsR+"\n"
						+ "verR: "+device.getValue().verR+"\n"
						+ "insR: "+device.getValue().insR+"\n"
						+ "conR: "+device.getValue().conR+"\n"
						+ "\n"
						+ "# Estimated cost (in milliseconds) to process the set of values for this device (eps, ver, ins).\n"
						+ "cost: "+device.getValue().cost+"\n"
						+ "\n"
						+ "# Bin ID associated to this device. It is used to identify the group (lambda) this device belongs to.\n"
						+ "bin: "+device.getValue().bin;
				try {
					FileOutputStream outputStream = new FileOutputStream(new File("devices/config/" + device.getKey() + ".yml"));
					byte[] strToBytes = output.getBytes();
					outputStream.write(strToBytes);
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void writeConfigDevicesToFile_old() {
		// name = 0, eps = 1, ver = 2, ins = 3, epsR = 4, verR = 5, insR = 6, conR = 7,
		// cost = 8, bin = 9
		try {
			String str = new String();
			for (int i = 0; i < prodDataFromFileV.size(); i++) {
				str += String.join(",", prodDataFromFileV.get(i)) + "\n";
			}
			FileOutputStream outputStream = new FileOutputStream(new File("devices.txt"));
			byte[] strToBytes = str.getBytes();
			outputStream.write(strToBytes);
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setDeviceBin(String binItem, String hash) {
		for (int i = 0; i < prodDataFromFileV.size(); i++) {
			if (prodDataFromFileV.get(i)[0].equals(binItem)) {
				prodDataFromFileV.get(i)[9] = hash;
				break;
			}
		}
	}

	public static String getHash(byte[] byteArray) {
		try {
			return org.apache.commons.codec.digest.DigestUtils.sha1Hex(byteArray);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "hash error";
		}
	}
}
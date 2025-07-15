package old;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataseCreation implements Runnable{
	File[] dsDirs;
	ArrayList<String> jsonPath;
	ArrayList<List<String>> jsonPathLines;
	File file;
	
	public DataseCreation(File file, ArrayList<String> jsonPath, ArrayList<List<String>> jsonPathLines) {
		this.file = file;
		this.jsonPath = jsonPath;
		this.jsonPathLines = jsonPathLines;
	}
	
	public void run() {
		String dsN = file.getName();
		List<String> jsonList = null;
		if (dsN.startsWith("cce100_")) {
			jsonList = jsonPathLines.get(0);
		} else if (dsN.startsWith("cce200_")) {
			jsonList = jsonPathLines.get(1);
		} else if (dsN.startsWith("cce400_")) {
			jsonList = jsonPathLines.get(2);
		} else if (dsN.startsWith("cce800_")) {
			jsonList = jsonPathLines.get(3);
		} else if (dsN.startsWith("cce1600_")) {
			jsonList = jsonPathLines.get(4);
		} else if (dsN.startsWith("cce3000_")) {
			jsonList = jsonPathLines.get(5);
		}
		
		for (int i = 0; i < 101; i++) {
			String ds = "";
			int count = 0;
			for (String str : jsonList) {
				if (str.contains("eventid")) {
					int rand = new Random().nextInt(100000000);
					//String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(rand + dsDirs[i].getName());   
					count++;
					str = "    \"eventid\": \""+ count + "-" + file.getName() + "-" + rand + "\",";
				}
				ds += str + "\n";
			}
			byte[] peB = ds.getBytes();
			try {
				Files.write(Paths.get(file + "/dataset"+ i +".json"), peB, StandardOpenOption.CREATE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// deprecated
	private static void deleteAllLambda() {
		
		File ruleDir = new File("/home/adriano/git/slicer/CCE/ruleupload/cce_rules");
		File[] rules = ruleDir.listFiles();
		for (int i = 0; i < rules.length; i++) {
			System.out.println("aws lambda delete-function --function-name "+rules[i].getName());
			execShellCommand("aws lambda delete-function --function-name "+rules[i].getName());
		}	
	}
	
	// deprecated
	private static String invokeLambda(String functionName) {
		String invokeCommand = "aws lambda invoke"
				+ " --function-name "+functionName
				+ " --payload fileb:///home/adriano/git/slicer/CCE/ruleupload/events/"+functionName+"/dataset.json"
				+ " out --log-type Tail --query 'LogResult' --output text |  base64 -d";
		
		return execShellCommand(invokeCommand);
	}
	
	// deprecated
	private static String execShellCommand(String command) {
		ProcessBuilder processBuilder = new ProcessBuilder();
	    processBuilder.command("bash", "-c", command);
	    try {
	    	String out = new String();
	        Process process = processBuilder.start();
	        StringBuilder output = new StringBuilder();
	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            output.append(line + "\n");
	            out = line;
	        }

	        int exitVal = process.waitFor();
	        if (exitVal == 0) {
	        	//return output.toString();
	        	return out;
	        } else {
	            //abnormal...
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		return "null";
	}

	private void replicateDataset() {
		String json100 = "default_events/100.json";
		String json200 = "default_events/200.json";
		String json400 = "default_events/400.json";
		String json800 = "default_events/800.json";
		String json1600 = "default_events/1600.json";
		String json3000 = "default_events/3000.json";
		jsonPath.add(json100);
		jsonPath.add(json200);
		jsonPath.add(json400);
		jsonPath.add(json800);
		jsonPath.add(json1600);
		jsonPath.add(json3000);
		
		try {
			Path path=null;
			for (int j = 0; j < jsonPath.size(); j++) {
				int count = 0;
				path = Paths.get(jsonPath.get(j));
				jsonPathLines.add(Files.readAllLines(path));
			}
		
			File dsPath = new File("cce_rules/");
			dsDirs = dsPath.listFiles();
			for (int i = 0; i < dsDirs.length; i++) {
				String spath = dsDirs[i].getAbsolutePath().replace("cce_rules", "events");
				if (dsDirs[i].toString().endsWith("1024")) {
					dsDirs[i] = new File(spath);
					if (!dsDirs[i].exists()) {
						dsDirs[i].mkdir();
					}
				}
				//dsDirs[i] = new File(spath);
				//if (!dsDirs[i].exists()) {
				//	dsDirs[i].mkdir();
				//}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		//deleteAllLambda();
		
		/*
		try {
			Path path = Paths.get("/home/adriano/git/slicer/CCE/ruleupload/functionnames.txt");
			List<String> funcNames = Files.readAllLines(path);
		
			for (int i = 0; i < funcNames.size(); i++) {
				String ret = invokeLambda(funcNames.get(i));
				int pos = ret.indexOf("Billed Duration: ");
				ret = ret.substring(pos);
				pos = ret.indexOf(" ms");
				ret = "\n" + funcNames.get(i) + "=" + ret.substring(17,pos);
				
				System.out.println(ret);
				byte[] peB = ret.getBytes();
				Files.write(Paths.get("/home/adriano/git/slicer/CCE/ruleupload/output.txt"), peB, StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
				
				
		
		DataseCreation utils = new DataseCreation(null, new ArrayList<String>(), new ArrayList<List<String>>());
		utils.replicateDataset();
		
		for (int i = 0; i < utils.dsDirs.length; i++) {
			Thread thread = new Thread(new DataseCreation(utils.dsDirs[i], utils.jsonPath, utils.jsonPathLines)); 
			thread.start();
		}
		
	}
}

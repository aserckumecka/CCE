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

public class LambdaInvoke2 {
	static String functionName = "correlation"; //"_43ce974942026550f9c2dc87d3cdb49b8e632d74";
	static String currentDirFile = System.getProperty("user.dir");
		
	public static void runLambda() {
		
		String invokeCommand = "aws lambda invoke"
				+ " --function-name "+functionName
				+ " --payload fileb://"+currentDirFile+"/default_events/testcorr.json"
				+ " out --log-type Tail --query 'LogResult' --output text |  base64 -d";
		
		ProcessBuilder processBuilder = new ProcessBuilder();
	    processBuilder.command("bash", "-c", invokeCommand);
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
	        System.out.println("Lambda output "+out);
	        
	        int exitVal = process.waitFor();
	        if (exitVal == 0) {
	        	int pos = out.indexOf("Billed Duration: ");
				out = out.substring(pos);
				pos = out.indexOf(" ms");
				out = "\n" + functionName + "=" + out.substring(17,pos);
				
				System.out.println(out);
				byte[] peB = out.getBytes();
				Files.write(Paths.get("output.txt"), peB, StandardOpenOption.APPEND);
	        } else {
	            //abnormal...
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	
	}
	
	public static void main(String args[]) {
		runLambda();
	}
}
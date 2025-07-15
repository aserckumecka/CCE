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

public class LambdaInvoke implements Runnable{
	String functionName;
	String currentDirFile = System.getProperty("user.dir");
	
	public LambdaInvoke(String functionName) {
		this.functionName = functionName;
	}
	
	public void run() {
		for (int i = 0; i < 101; i++) { // 100 execuções para cada lambda (fazer média depois) descarta a 1a
			String invokeCommand = "aws lambda invoke"
					+ " --function-name "+functionName
					+ " --payload fileb://"+currentDirFile+"/events/"+functionName+"/dataset"+i+".json"
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
	}
	
	public static void main(String args[]) {
		//deleteAllLambda();
		
		try {
			Path path = Paths.get("functionnames.txt");
			List<String> funcNames = Files.readAllLines(path);
			LambdaInvoke lambdaInvoke;
			for (int i = 0; i < funcNames.size(); i++) {
				lambdaInvoke = new LambdaInvoke(funcNames.get(i));
				Thread thread = new Thread(lambdaInvoke); 
				thread.start();
				//utils2.run();
				//Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LambdaDelete {

	public static void main(String[] args) throws IOException {
		deleteAllLambda();
	}

	private static void deleteAllLambda() throws IOException {
		List<String> funcNames = Files.readAllLines(Paths.get("functionnames.txt")); 
		for (String string : funcNames) {
			System.out.println("aws lambda delete-function --function-name "+string);
			execShellCommand("aws lambda delete-function --function-name "+string);
		}
	}
	
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
}

package cce.ruleupload;

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

public class Bins_DeployCode {

	static String currentDirFile = System.getProperty("user.dir");
	static String codeTemplatePath = currentDirFile + "/rule_template_code/"; //rule code destination
	static File codeTemplatePathFile = new File(codeTemplatePath);
	
	//public static void codeDeploy(ArrayList<String> lambdaName) {
		//for (String string : lambdaName) {
			//generateRuleCodeFromTemplate(string, null);
		//}
	//}
	
	public static void generateRuleCodeFromTemplate(String lambdaName, String artifactid) {
		String archetGenerateCommand = "mvn archetype:generate"
				+ " -DarchetypeGroupId=com.amazonaws.serverless.archetypes"
				+ " -DarchetypeArtifactId=" + artifactid 
				+ " -DarchetypeVersion=1.0.0"
				+ " -DarchetypeRepository=local" 
				+ " -DinteractiveMode=false" 
				+ " -DgroupId=cce" 
				+ " -DartifactId=" + lambdaName 
				+ " -Dversion=1.0.0" 
				+ " -DclassName=" + lambdaName;
		execShellCommand(archetGenerateCommand, codeTemplatePath);
	}
	
	public static void injectRuleCode(ArrayList<String> verifVars, ArrayList<String> vefifCodes, ArrayList<String> condCodes, String className) {
		List<String> javaRuleLines;
		try {
			Path javaCodePath = Paths.get("rule_template_code/" + className + "/src/main/java/cce/" + className + ".java");
			javaRuleLines = Files.readAllLines(javaCodePath);
			String newJavaRule = new String();
			for (int i = 0; i < javaRuleLines.size(); i++) {
				String tmp = javaRuleLines.get(i);
				if (tmp.contains("//verifVars")) {
					javaRuleLines.addAll(i+1, verifVars);
				} else if (tmp.contains("//verifCodes")) {
					javaRuleLines.addAll(i+1, vefifCodes);
				} else if (tmp.contains("//condCodes")) {
					javaRuleLines.addAll(i+1, condCodes);
				}
				newJavaRule += javaRuleLines.get(i) + "\n";
			}
			System.out.println(newJavaRule);
			byte[] peB = newJavaRule.getBytes();
			Files.write(javaCodePath, peB, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deployLambdaRule(String path, String className, String memSize) {
		String installCommand = "mvn clean install";
		String packageCommand = "sam package" 
				+ " --s3-bucket cce-bucket" 
				+ " --s3-prefix "+className
				+ " --template-file template.yaml" 
				+ " --output-template-file target/sam.yaml" 
				+ " --region sa-east-1";
		String deployCommand = "aws lambda create-function"
				+ " --region sa-east-1"
				+ " --function-name " + className
				+ " --runtime java11"
				+ " --handler cce." + className
				+ " --zip-file fileb://target/" + className + "-1.0.0.jar"
				+ " --timeout 60"
				+ " --memory-size " + memSize
				+ " --role arn:aws:iam::201560601476:role/LambdaFullAccess";
				//+ " --environment \"Variables={JAVA_TOOL_OPTIONS=-XX:+TieredCompilation -XX:TieredStopAtLevel=1}\"";
		String updateCommand = "aws lambda update-function-configuration"
				+ " --function-name " + className
				+ " --environment \"Variables={JAVA_TOOL_OPTIONS = -XX:+TieredCompilation -XX:TieredStopAtLevel=1}\"";
		/*String deployCommand = "sam deploy" 
				+ " --template-file "+path+"target/sam.yaml" 
				+ " --capabilities CAPABILITY_IAM"
				+ " --stack-name "+ className
				+ " --region sa-east-1" 
				+ " --s3-bucket cce-bucket" 
				+ " --s3-prefix "+className;
		*/
		ArrayList<String> commands = new ArrayList<String>();
		commands.add(installCommand);
		commands.add(packageCommand);
		commands.add(deployCommand);
		//commands.add(updateCommand);
		
		for (String command : commands) {
			execShellCommand(command, path);
		}
		//execShellCommand(new String("updateCommand.sh "+className), "updateCommand");
	}
	
	public static void updateLambdaConfig(String className) {
		try {
			Runtime.getRuntime().exec(new String[] { "/bin/bash", "-c", "sh updateCommand.sh " + className});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean deleteFiles(File dir) {
	    File[] allContents = dir.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	        	deleteFiles(file);
	        }
	    }
	    return dir.delete();
	}
	
	public static void execShellCommand(String command, String path) {
		try {
			Process process = Runtime.getRuntime().exec(
					command, 
					null, 
					new File(path));

			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println(output);
				//System.exit(0);
			} else {
				// abnormal...
				System.out.println(output);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException {
		//Runtime.getRuntime().exec(new String[] { "/bin/bash", "-c", "sh updateCommand.sh correlation" });
	}
}

package old;

import org.yaml.snakeyaml.Yaml;

import cce.ruleupload.SigmaMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * created by Adriano Serckumecka
 *
 */
public class LoadRule {
	//static String[] yamlRules;

	public static void main(String[] args) throws IOException {
		loadRules();
		
	}

	// Load the rule files (YAML) to generate java code
	private static void loadRules() throws IOException {
		SigmaMapping sigmamap;
		Yaml yaml = new Yaml();
		String currentDirFile = System.getProperty("user.dir");
		String codeTemplatePath = currentDirFile + "/rule_template/"; //rule code destination
		File codeTemplatePathFile = new File(codeTemplatePath);
		
		File rulepath = new File("cce_rules/"); // YML rule files
		if (!rulepath.exists()) {
			rulepath.mkdir();
		}
		if (!codeTemplatePathFile.exists()) {
			codeTemplatePathFile.mkdir();
		}
		
		File[] ruleDirs = rulepath.listFiles(); // folders of each rule
		if (ruleDirs.length > 0) {
			// each iteration (directory) will be a lambda...
			for (int i = 0; i < ruleDirs.length; i++) {
				if (ruleDirs[i].isDirectory()) {
					String ruleGroupName = ruleDirs[i].getName();
					File[] rules = ruleDirs[i].listFiles();
					if (rules.length > 0) {
						ArrayList<String> methods = new ArrayList<String>();
						String codeMethods = "\n";
						String callMethods = "\n";
						for (int j = 0; j < rules.length; j++) {
							System.out.println(rules[j]);
							InputStream inputStream = new FileInputStream(rules[j]);
							Reader reader = new InputStreamReader(inputStream);
							LinkedHashMap<String, Object> yamlRuleObj = yaml.load(reader);// from yaml file.
							sigmamap = new SigmaMapping(yamlRuleObj);
							methods.add(ruleCreator(sigmamap, ruleGroupName) + "\n\n");
							callMethods += "			rule" + sigmamap.getId().replace("-", "") + "(eventMap);\n";
						}
						for (String method : methods) {
							codeMethods += method;
						}
						generateRuleCodeFromTemplate(codeTemplatePath, ruleGroupName);
						injectRuleCode(codeMethods, callMethods, ruleGroupName);
						String memSize = "";
						if (ruleGroupName.contains("512")) {
							memSize="512";
						}else if (ruleGroupName.contains("1024")) {
							memSize="1024";
						}else if (ruleGroupName.contains("1792")) {
							memSize="1792";
						}else if (ruleGroupName.contains("3008")) {
							memSize="3008";
						}
						deployLambdaRule(codeTemplatePath+ruleGroupName, ruleGroupName, memSize);
						//deleteLambdaCode(new File(codeTemplatePath+ruleGroupName));
					}
				}
			}
		}
	}

	
	private static boolean deleteLambdaCode(File dir) {
	    File[] allContents = dir.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	        	deleteLambdaCode(file);
	        }
	    }
	    return dir.delete();
	}

	private static String ruleCreator(SigmaMapping sigmaMapping, String ruleGroupName) {
		LinkedHashMap<String, String> detectionEntries = new LinkedHashMap<String, String>();
		// ################################ CONDITION ################################
		// Condition used to determine the detection method
		ArrayList<String> conditionTerms = new ArrayList<String>();
		ArrayList<String> operators = new ArrayList<String>();
		ArrayList<String[]> conditionTermsMap = new ArrayList<String[]>();
		String condition = String.valueOf(sigmaMapping.getDetection().get("condition"));
		sigmaMapping.getDetection().remove("condition");
		condition.trim();

		if (condition.equals("1 of them")) {
			conditionTerms.add("oneofthem");
		} else if (condition.equals("all of them")) {
			conditionTerms.add("allofthem");
		} else {
			if (condition.contains("1 of ")) {
				condition = condition.replace("1 of ", "one:");
			}
			if (condition.contains("all of ")) {
				condition = condition.replace("all of ", "all:");
			}
			if (condition.contains("not ")) {
				condition = condition.replace("not ", "not:");
			}
			conditionTerms = new ArrayList<String>(Arrays.asList(condition.split(" ")));
			for (int i = 0; i < conditionTerms.size(); i++) {
				String condTerm = conditionTerms.get(i);
				if (!(condTerm.equals("and") || condTerm.contentEquals("or"))) {
					String[] kv = new String[2];
					if (condTerm.contains(":")) {
						kv = condTerm.split(":");
					} else {
						kv[0] = "def"; // default (Map == and, Array == or) and not "one, all, not"
						kv[1] = condTerm;
						//System.out.println("## !op ## def / " + condTerm);
					}
					conditionTermsMap.add(kv);
				} else {
					operators.add(condTerm);
					//System.out.println("## op ## " + condTerm);
				}
			}
		}
		// ################################ DETECTION ################################
		// Iterate the "detection" LinkedHashMap fields to get nested
		// Strings/LinkedHashMap/ArrayList

		for (Map.Entry<String, LinkedHashMap<String, Object>> detectionLHM : sigmaMapping.getDetection().entrySet()) {
			String detectionKeyLHM = detectionLHM.getKey();
			Object detectionValueLHM = detectionLHM.getValue();
			//String entries = new String();
			String preop = new String();
			for (int i = 0; i < conditionTermsMap.size(); i++) {
				if (conditionTermsMap.get(i)[1].equals(detectionKeyLHM)) {
					preop = conditionTermsMap.get(i)[0];
					break;
				} else
					preop = "def";
			}

			// ############## Detection Terms code creation #################
			detectionValueLHM = detectionValueLHM == null ? "null" : detectionValueLHM;
			String conditionCode = CodeGen.conditionCreator(preop, detectionKeyLHM, detectionValueLHM, ruleGroupName);
			//entries += condCodes;
			detectionEntries.put(detectionKeyLHM, conditionCode);
		}
		return CodeGen.ruleCodeCreator(sigmaMapping, detectionEntries, operators);
	}

	
	private static void generateRuleCodeFromTemplate(String path, String lambdaName) {
		String archetGenerateCommand = "mvn archetype:generate "
				+ " -DarchetypeGroupId=com.amazonaws.serverless.archetypes"
				+ " -DarchetypeArtifactId=aws-serverless-java-archetype" 
				+ " -DarchetypeVersion=1.0.0"
				+ " -DarchetypeRepository=local" 
				+ " -DinteractiveMode=false" 
				+ " -DgroupId=cce" 
				+ " -DartifactId=" + lambdaName 
				+ " -Dversion=1.0.0" 
				+ " -DclassName=" + lambdaName;
		execShellCommand(archetGenerateCommand, path);
	}

	
	private static void injectRuleCode(String ruleCode, String methodName, String lambdaRuleGroup) {
		List<String> javaRuleLines;
		try {
			Path javaCodePath = Paths
					.get("rule_template/" + lambdaRuleGroup + "/src/main/java/cce/" + lambdaRuleGroup + ".java");
			javaRuleLines = Files.readAllLines(javaCodePath);
			String newJavaRule = new String();
			for (int i = 0; i < javaRuleLines.size(); i++) {
				String tmp = javaRuleLines.get(i);
				if (tmp.contains("//rule_methods")) {
					javaRuleLines.set(i, ruleCode);
				} else if (tmp.contains("//call_methods")) {
					javaRuleLines.set(i, methodName);
				}
				newJavaRule += javaRuleLines.get(i) + "\n";
			}

			byte[] peB = newJavaRule.getBytes();
			Files.write(javaCodePath, peB, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static void deployLambdaRule(String path, String ruleGroupName, String memSize) {
		String installCommand = "mvn clean install";
		String packageCommand = "sam package" 
				+ " --s3-bucket cce-bucket" 
				+ " --s3-prefix "+ruleGroupName
				+ " --template-file template.yaml" 
				+ " --output-template-file target/sam.yaml" 
				+ " --region sa-east-1";
		String deployCommand = "aws lambda create-function"
				+ " --region sa-east-1"
				+ " --function-name " + ruleGroupName
				+ " --runtime java11"
				+ " --handler cce." + ruleGroupName
				+ " --zip-file fileb://target/" + ruleGroupName + "-1.0.0.jar"
				+ " --timeout 60"
				+ " --memory-size " + memSize
				+ " --role arn:aws:iam::201560601476:role/LambdaFullAccess"; 
		/* String deployCommand = "sam deploy" 
				+ " --template-file target/sam.yaml" 
				+ " --capabilities CAPABILITY_IAM"
				+ " --stack-name "+ ruleGroupName
				+ " --region sa-east-1" 
				+ " --s3-bucket cce-bucket" 
				+ " --s3-prefix "+ruleGroupName;
		 */
		ArrayList<String> commands = new ArrayList<String>();
		commands.add(installCommand);
		commands.add(packageCommand);
		commands.add(deployCommand);
		
		for (String command : commands) {
			execShellCommand(command, path);
		}
	}
	
	
	private static void execShellCommand(String command, String path) {
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
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
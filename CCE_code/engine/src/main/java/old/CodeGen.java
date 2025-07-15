package old;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import cce.ruleupload.SigmaMapping;

public class CodeGen {
	static String condition;
	static String createAlert;
	
	public static void writeSelectionField(String sKey, String ruleGroupName) {
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(ruleGroupName + ".txt", true));
	    	writer.append(sKey+"\n");
	    	writer.close();
	    	System.out.println("Successfully wrote to the file "+ ruleGroupName + ".txt");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static String conditionCreator(String preop, String rootKey, Object value, String ruleGroupName) { // operator can be "not" or "any"
		condition = new String();
		String ret;
		String op = new String();
		boolean isLHM = value.getClass() == LinkedHashMap.class ? true : false;
		if (preop.equals("all") || (preop.equals("def") && isLHM)) {
			op = " && ";
		}else {
			op = " || "; // "1 of" or "ArrayList"
		} 
		if (isLHM) {
			for (Map.Entry<String, Object> selection : ((LinkedHashMap<String, Object>) value).entrySet()) {
				String sKey = selection.getKey();
				Object sValue = selection.getValue();
				sValue = sValue == null ? "null" : sValue;
				// write the fields used in this rule
				//writeSelectionField(sKey, ruleGroupName);
				if (sValue.getClass() == ArrayList.class) {
					String condArray = new String();
					ArrayList<String> sValueArray = (ArrayList<String>)sValue;
					for (int i = 0; i < sValueArray.size(); i++) {
						ret = getConditional(sKey, preop, sValueArray.get(i));
						condArray += " || " + ret;
					}
						condArray = condArray.substring(4);
					condition += op + "("+condArray+")";
				} else {
					ret = getConditional(sKey, preop, String.valueOf(sValue));
					condition += op + ret;
				}
			}
			// delete first op...
			if (condition.startsWith(" && ") || condition.startsWith(" || ")) {
				condition = condition.substring(4);
			}
			
		}else if (value.getClass() == ArrayList.class) {
			ArrayList<String> valueArray = (ArrayList<String>)value;
			for (int i = 0; i < valueArray.size(); i++) {
				ret = getConditional(rootKey, preop, valueArray.get(i));
				condition += op + ret;
			}
			// delete first op...
			if (condition.startsWith(" && ") || condition.startsWith(" || ")) {
				condition = condition.substring(4);
			}
		} else { 
			ret = getConditional(rootKey, preop, String.valueOf(value));
			condition = ret;
		}
		return defaultConditCode(rootKey);
	}

	
	private static String defaultConditCode(String rootKey) {
		String code = new String();
		String inverseCreateAlert = createAlert.equals("true") ? "false" : "true";
		// ########################### CODE #################################
		code += "    boolean " + rootKey + " = " + inverseCreateAlert +";\n";
		code += "    try {\n";
		code += "        if (" + condition + ") {\n";
		code += "            " + rootKey + " = "+ createAlert +";\n";
		code += "        }\n";
		code += "    }catch (NullPointerException ex) {}\n";
		// ##################################################################
		return code;
	}
	
	public static String getConditional(String key, String preop, String value) {
		String cond = new String();
		createAlert = "true";
		if (value.contains("\\*")) {
			value = value.replace("\\*", "*");
		}
		if (value.contains("\\")) {
			value = value.replace("\\", "\\\\");
		}
		
		if (value.startsWith("*") && value.endsWith("*")) {
			value = value.replace("*", "");
			cond = "eventMap.get(\"" + key + "\").contains(\"" + value + "\")";
		} else if (value.startsWith("*")) {
			value = value.replace("*", "");
			cond = "eventMap.get(\"" + key + "\").endsWith(\"" + value + "\")";
		} else if (value.endsWith("*")) {
			value = value.replace("*", "");
			cond = "eventMap.get(\"" + key + "\").startsWith(\"" + value + "\")";
		} else {
			cond = "eventMap.get(\"" + key + "\").equals(\"" + value + "\")";
		}
		//invert the value to false in the code due to the "not" operator.
		if (preop.equals("not")) {
			createAlert = "false";
		} 
		return cond;
	}
	
	public static String ruleCodeCreator(SigmaMapping sigma, LinkedHashMap<String, String> dEntriesValue, ArrayList<String> operators) {
		String code = new String();
		String conditionalCreateAlert = new String();
		
		code = "    private void "+ "rule"+sigma.getId().replace("-", "") +"(HashMap<String, String> eventMap) {\n";
		
		for (Map.Entry<String, String> dEntry : dEntriesValue.entrySet()) {
			String entryKey = dEntry.getKey();
			String entryValue = dEntry.getValue();
			code += entryValue + "\n";
			
			String op = "";
			if(operators.size() == 0) {
				op = "";
			}else { 
				op = operators.get(0);
				operators.remove(0);
			}
			if (op.contentEquals("and")) {
				op = " && ";
			}else if (op.contentEquals("or")) {
				op = " || ";
			}
			conditionalCreateAlert += entryKey + op;
		}
		
		//HashMap<String, String> eventMap = new HashMap<String, String>();
		 
		code += "        if ("+conditionalCreateAlert+"){\n";
		code += "            HashMap<String, String> ruleInfo = new HashMap<String, String>();\n"; 
		
		if (!(sigma.getTitle() == null)) {
			code += "            ruleInfo.put(\"title\", \""+sigma.getTitle()+"\");\n";
		}
		if (!(sigma.getId() == null)) {
			code += "            ruleInfo.put(\"id\", \""+sigma.getId()+"\");\n";
		}
		if (!(sigma.getRelated() == null)) {
			code += "            ruleInfo.put(\"related\", \""+sigma.getRelated().toString()+"\");\n";
		}
		if (!(sigma.getLicense() == null)) {
			code += "            ruleInfo.put(\"license\", \""+sigma.getLicense()+"\");\n";
		}
		if (!(sigma.getStatus() == null)) {
			code += "            ruleInfo.put(\"status\", \""+sigma.getStatus()+"\");\n";
		}
		if (!(sigma.getDescription() == null)) {
			code += "            ruleInfo.put(\"description\", \""+sigma.getDescription()+"\");\n";
		}
		if (!(sigma.getAuthor() == null)) {
			code += "            ruleInfo.put(\"author\", \""+sigma.getAuthor()+"\");\n";
		}
		if (!(sigma.getReferences() == null)) {
			code += "            ruleInfo.put(\"references\", \""+sigma.getReferences().toString()+"\");\n";
		}
		if (!(sigma.getLogsource() == null)) {
			code += "            ruleInfo.put(\"logsource\", \""+sigma.getLogsource().toString()+"\");\n";
		}
		if (!(sigma.getFields() == null)) {
			code += "            ruleInfo.put(\"fields\", \""+sigma.getFields().toString()+"\");\n";
		}
		if (!(sigma.getFalsepositives() == null)) {
			code += "            ruleInfo.put(\"falsepositives\", \""+sigma.getFalsepositives().toString()+"\");\n";
		}
		if (!(sigma.getLevel() == null)) {
			code += "            ruleInfo.put(\"level\", \""+sigma.getLevel()+"\");\n";
		}
		if (!(sigma.getTags() == null)) {
			code += "            ruleInfo.put(\"tags\", \""+sigma.getTags().toString()+"\");\n";
		}
		if (!(sigma.getMatch() == null)) {
			code += "            ruleInfo.put(\"match\", \""+sigma.getMatch()+"\");\n\n";
		}
		
		code += "            ArrayList<HashMap<String, String>> params = new ArrayList<HashMap<String,String>>();\n";
		code += "            params.add(ruleInfo);\n";
		code += "            params.add(eventMap);\n";
		code += "            createAlert(params);\n";
		code += "        }\n";
		code += "    }\n";
		
		//System.out.println(code);
		return code;
	}
	
	public static void main(String args[]) {
		System.out.println("test");
	}
}

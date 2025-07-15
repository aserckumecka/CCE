package cce.ruleupload;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Rule_Condition_GenCode {
	static LinkedHashMap<String, ArrayList<String>> verifVars = new LinkedHashMap<String, ArrayList<String>>();
	static LinkedHashMap<String, ArrayList<String>> verifCodes = new LinkedHashMap<String, ArrayList<String>>();
	static LinkedHashMap<String, ArrayList<String>> condCodes = new LinkedHashMap<String, ArrayList<String>>();
	
	public static LinkedHashMap<String, ArrayList<String>> getVerifVars() {
		return verifVars;
	}

	public static LinkedHashMap<String, ArrayList<String>> getVerifCodes() {
		return verifCodes;
	}

	public static LinkedHashMap<String, ArrayList<String>> getCondCodes() {
		return condCodes;
	}
	
	public static void main(String[] args) {
	}
	
	@SuppressWarnings("unchecked")
	public static boolean generateCondCode(LinkedHashMap<String, Rule_Condition_Data> ruleCondProductArray) {
		//Rule_Condition_Data correlationRules = ruleCondProductArray.get("correlationRules");
		//ruleCondProductArray.remove("correlationRules");
		
		// iterate each product data class
		for (Map.Entry<String, Rule_Condition_Data> ruleCondProduct : ruleCondProductArray.entrySet()) {
			String rcProduct_key = ruleCondProduct.getKey();
			Rule_Condition_Data rcProduct_value = ruleCondProduct.getValue();
			ArrayList<String> matchCond = new ArrayList<String>(); // ArrayList containing the events that match this condition.
			ArrayList<String> detecCode = new ArrayList<String>(); // each string is an item of code, not a line code...
			ArrayList<String> condCode = new ArrayList<String>(); // each string is a condition.
			System.out.println("\n\n"+rcProduct_key);
			String evt_match = rcProduct_key.replace(".", "_");
			
			// DETEC CODE
			detecCode.add("		if (dvchost.equals(\""+rcProduct_key+"\")) {");
			detecCode.add("		    "+evt_match+"_evt++;");
			
			matchCond.add("        int " + evt_match + "_match = 0;");
			matchCond.add("        int " + evt_match + "_evt = 0;");

			// #####################################################################
			// iterate each rule condition item
			for (Map.Entry<String, Object> rc_items : rcProduct_value.ruleConditionsLHM.entrySet()) {
				
				matchCond.add("	ArrayList<String> "+rc_items.getKey() + " = new ArrayList<String>();");
				//System.out.println("rc_items: " + rc_items.getKey());
				
				ObjectMapper oMapper = new ObjectMapper();
		        LinkedHashMap<String, Object> rc_items_value = oMapper.convertValue(rc_items.getValue(), LinkedHashMap.class);
		        String code = "\n			if (";
		        		        
		        // #############  detecCode  #############
				for (Map.Entry<String, Object> rc_items_sub : rc_items_value.entrySet()) {
					String rc_items_sub_key = rc_items_sub.getKey();
					Object rc_items_sub_value = rc_items_sub.getValue();
					
					//System.out.println("rc_items_sub_key: "+rc_items_sub_key);
					int count = 0;
					
					if (rc_items_sub_value.getClass() == LinkedHashMap.class) {
						LinkedHashMap<String, Object> rc_items_sub2 = (LinkedHashMap<String, Object>) rc_items_sub_value;
						
						for (Map.Entry<String, Object> rc_items_sub3 : rc_items_sub2.entrySet()) {
							String rc_items_sub3_key = rc_items_sub3.getKey();
							Object rc_items_sub3_value = rc_items_sub3.getValue();
							//System.out.println("LHM rc_items_sub3_key: "+rc_items_sub3_key);
							String[] keyArray2 = rc_items_sub3_key.split("\\.");
							String key2 = keyArray2[keyArray2.length-1];
							if (count > 0) {
								code += " && (";
							}else {
								code += "(";
							}
							count++;
							
							if (rc_items_sub3_value.getClass() == ArrayList.class) {
								int count2 = 0;
								ArrayList<String> rc_items_sub4 = (ArrayList<String>) rc_items_sub3_value;
								for (String rc_items_sub4_value : rc_items_sub4) {
									//System.out.println("LHM-AL rc_items_sub4_value: "+rc_items_sub4_value);
									if (count2 > 0) {
										code += " || ";
									}
									count2++;
									code += verifyCondition(key2, rc_items_sub4_value);
								}
								
							} else { // String
								code += verifyCondition(key2, rc_items_sub3_value.toString());
								//System.out.println("LHM-S rc_items_sub4_value: "+String.valueOf(rc_items_sub3_value));
							}
							code += ")";
						}
						
					} else if (rc_items_sub_value.getClass() == ArrayList.class) {
						ArrayList<String> rc_items_sub2 = (ArrayList<String>) rc_items_sub_value;
						String[] keyArray = rc_items_sub_key.split("\\.");
						String key = keyArray[keyArray.length-1];
						int count2 = 0;
						for (String rc_items_sub2_value : rc_items_sub2) {
							//System.out.println("AL rc_items_sub2_value: "+rc_items_sub2_value);
							if (count2 > 0) {
								code += " || ";
							}
							count2++;
							code += verifyCondition(key, rc_items_sub2_value);
						}
						
					} else {
						//System.out.println("String: "+String.valueOf(rc_items_sub_value));
						String keyArray[] = rc_items_sub_key.split("\\.");
						String key = keyArray[keyArray.length-1];
						code += verifyCondition(key, rc_items_sub_value.toString());
					}
					//System.out.println(rc_items_sub.getValue().getClass());
					code += "){";
				}
				code += "\n    				" + rc_items.getKey() + ".add(\"eventid=\"+ eventid +\", \"+ \"dvchost=\"+ dvchost +\", \"+ \"rt=\"+ rt);";
				code += "\n			}";
				
				//System.out.println(rc_items.getKey());
				//System.out.println(rc_items.getValue()+"\n");
				System.out.println(code);
				detecCode.add(code);
			}
			detecCode.add("\n		}");
			verifCodes.put(rcProduct_key, detecCode);
			verifVars.put(rcProduct_key, matchCond);
			
			
			
			ArrayList<String> itemsCR = new ArrayList<String>();
			
			// #####################################################################
			// iterate each condition regex
			for (String correlation_items[] : rcProduct_value.conditionRegex) {
				String code = "";
				System.out.println("\nCorrelation items");
				
				for (String corr : correlation_items) {
					System.out.println(corr);
				}
				
				ArrayList<String> items = new ArrayList<String>();
				String temp = correlation_items[0].replace("(", "( ");
				temp = temp.replace(")", " )");
				String[] corrItems0 = temp.split(" ");
				
				for (String corrItem : corrItems0) {
					if (corrItem.startsWith("_")) {
						items.add(corrItem);
						if (rcProduct_key.equals("correlationRules")) {
							boolean itemExists = false;
							String itemsCRstring = "		ArrayList<String> "+ corrItem +" = getAlert(\""+corrItem+"\", \""+correlation_items[4]+"\");";
							for (String itemCR : itemsCR) {
								if (itemCR.equals(itemsCRstring)) {
									itemExists = true;
									break;
								}
							}
							if(!itemExists) {
								itemsCR.add(itemsCRstring);
							}
							itemExists = false;
						}
					}
				}
				
				String temp2 = correlation_items[0].replace("and", ";");
				temp2 = temp2.replace("or", ";");
				corrItems0 = temp2.split(";");
				
				for (int i=0; i<corrItems0.length; i++) {
					if (rcProduct_key.equals("correlationRules")) {
						if (corrItems0[i].contains(">")) {
							correlation_items[0] = correlation_items[0].replace(items.get(i), items.get(i)+".size()");
						}else
							correlation_items[0] = correlation_items[0].replace(items.get(i), items.get(i)+".size() > 0");
					}else
						correlation_items[0] = correlation_items[0].replace(items.get(i), items.get(i)+".size() > 0");
				}
				code = "\n		if (";
				correlation_items[0] = correlation_items[0].replace("or", "||");
				correlation_items[0] = correlation_items[0].replace("and", "&&");
				code += correlation_items[0];
				code += ") {";
				
				if (rcProduct_key.equals("correlationRules")) {
					code += "\n    			ArrayList<String> matches = new ArrayList<String>();";
					
					for (String item : items) {
						code += "\n    			matches.addAll("+item+");";
					}
				
					if (correlation_items[1].equals("Alarm")) { // Alarm
						code += "\n    			String ruleId = \""+correlation_items[2]+"\";";
						code += "\n    			String ruleInfo = \""+correlation_items[3].replace("\"", "")+"\";";
						code += "\n    			String severity = \""+correlation_items[5]+"\";";
						code += "\n    			createAlarm(matches, ruleInfo, ruleId, severity);";
					}					
				}else { // other than correlation rule (stateless...)
					if (correlation_items[1].equals("Alarm")) { // Alarm
						code += "\n    			ArrayList<String> matches = new ArrayList<String>();";
						code += "\n    			String ruleId = \""+correlation_items[2]+"\";";
						code += "\n    			String severity = \""+correlation_items[4]+"\";";
						code += "\n    			String ruleInfo = \""+correlation_items[3].replace("\"", "")+"\";";
						for (String item : items) {
							code += "\n    			matches.addAll("+item+");";
						}
						code += "\n    	           createAlarm(matches, ruleInfo, ruleId, severity);";
						code += "\n                "+evt_match+"_match++;";
					}else { // Alert
						String corrId = correlation_items[0].substring(correlation_items[0].indexOf("_"), correlation_items[0].indexOf("."));
						//code += "\n    			String corrId = "+corrId+".toString();";
						code += "\n            for(String evt : "+items.get(0)+"){";
						code += "\n		           createAlert(evt, \""+corrId+"\");";
						code += "\n	               "+evt_match+"_match++;";
						code += "\n            }";
					}
				}
				code += "\n		}";
				condCode.add(code);
				
				
			}
			if (rcProduct_key.equals("correlationRules")) {
				verifVars.put("correlationRules", itemsCR);
			}else {
				condCode.add("\n        ret += \"" + evt_match + "_ins_\" + " + evt_match+"_match + \",\";");
				condCode.add("\n        ret += \"" + evt_match + "_eps_\" + " + evt_match+"_evt + \",\";");
			}
			
			condCodes.put(rcProduct_key, condCode);
		}
		
		System.out.println("\n verifVars");
		for (Entry<String, ArrayList<String>> arrayList : verifVars.entrySet()) {
			System.out.println(arrayList.toString());
		}
		System.out.println("\n");
		
		System.out.println("\n detecCodes");
		for (Entry<String, ArrayList<String>> arrayList : verifCodes.entrySet()) {
			System.out.println(arrayList.toString());
		}
		System.out.println("\n");
		
		System.out.println("\n condCodes");
		for (Entry<String, ArrayList<String>> arrayList : condCodes.entrySet()) {
			System.out.println(arrayList.toString());
		}
		System.out.println("\n");
		
		return true;
	}
	
	private static String verifyCondition(String key, String value) {
		String cond = new String();
		if (value.startsWith("*") && value.endsWith("*")) {
			value = value.replace("*", "");
			cond = "eventMap.getOrDefault(\"" + key + "\", \"rt\").contains(\"" + value + "\")";
		} else if (value.startsWith("*")) {
			value = value.replace("*", "");
			cond = "eventMap.getOrDefault(\"" + key + "\", \"rt\").endsWith(\"" + value + "\")";
		} else if (value.endsWith("*")) {
			value = value.replace("*", "");
			cond = "eventMap.getOrDefault(\"" + key + "\", \"rt\").startsWith(\"" + value + "\")";
		} else {
			cond = "eventMap.getOrDefault(\"" + key + "\", \"rt\").equals(\"" + value + "\")";
		}
		if (value.startsWith("!")) {
			cond = cond.replace("!", "");
			cond = "!" + cond;
		}
		return cond;
	}
}


package cce.ruleupload;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.json.JSONObject;

public class Rule_Condition_Data {
	//public int countVerifications = 0;
	public int triggerGap; //here, represents the waiting time to trigger a new function.
	public String productName;
	public int eps = 0; // events per second
	public int ver = 0; // number of verifications
	public double ins = 0; // percentage of inserts into DB (alerts and alarms)
	public float epsR = 0; // events per second
	public float verR = 0; // number of verifications
	public float insR = 0; // percentage of inserts into DB (alerts and alarms)
	public float conR = 0; // constant value (to calculate power regression)
	public int cost = 0; // the cost in milliseconds to run based on the power regression formula. (default)
	public int cost_bincap = 0; // the cost in milliseconds to run based on the power regression formula. (bincap dependant)
	public String bin;
	public BlockingQueue<JSONObject> queue = new ArrayBlockingQueue<JSONObject>(50000);
	public LinkedHashMap<String, Object> ruleConditionsLHM = new LinkedHashMap<String, Object>();
	// conditionRegex: expression that verifies the condition rules to then trigger an alarm.
	public ArrayList<String[]> conditionRegex = new ArrayList<String[]>();
	
	public Rule_Condition_Data() {
		
	}
	
	public Rule_Condition_Data(String productNameVector[]) {
		productName = productNameVector[0]; // device name
		eps = Integer.parseInt(productNameVector[1]); // events per second
		ver = Integer.parseInt(productNameVector[2]); // number of verifications
		ins = Double.parseDouble(productNameVector[3]); // percentage of database insertions
		epsR = Float.parseFloat(productNameVector[4]);// reference value to calculate the power regression
		verR = Float.parseFloat(productNameVector[5]);// reference value to calculate the power regression
		insR = Float.parseFloat(productNameVector[6]);// reference value to calculate the power regression
		conR = Float.parseFloat(productNameVector[7]);// reference value to calculate the power regression
		bin = productNameVector[9]; //bin name where the verifications of this device are allocated
		calculateCost();
	}
	
	public void calculateCost() {
		int nins = (int) ((eps*ins)/100); //calculate the number of inserts
		int nins_bincap = (int) (((eps*(triggerGap/1000))*ins)/100);
		cost = (int) ((Math.pow(eps, epsR) * Math.pow(ver, verR) * Math.pow(nins, insR)) * conR);
		cost_bincap = (int) ((Math.pow(eps*(triggerGap/1000), epsR) * Math.pow(ver, verR) * Math.pow(nins_bincap, insR)) * conR);
		//System.out.println("Device: " + productName);
		//System.out.println("Cost: " + cost);
		//System.out.println("Cost/bincap: " + cost_bincap);
	}
	
}

package ${package};

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class ${className} implements RequestHandler<List<HashMap<String, String>>, String> {
	long lambda_ts = 0;
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
	DynamoDB dynaDB = new DynamoDB(client);
	ArrayList<String> alarms = new ArrayList<String>();
	int countAlarms = 0;

	@Override
	public String handleRequest(List<HashMap<String, String>> eventBatch, Context context) {
    		lambda_ts = System.currentTimeMillis();
    		LambdaLogger logger = context.getLogger();
    		
    		//verifVars

		//condCodes
    		
    		String ret = countAlarms + " alarms created by rules: " + alarms.toString();
    		countAlarms = 0;
    		alarms = new ArrayList<String>();
    		logger.log("Result: " + ret);
		return ret;
	}

	private ArrayList<String> getAlert(String rc_id, String timeframe) {
		Table table = dynaDB.getTable("AlertDB");
		long days = 0;
		long hours = 0;
		long minutes = 0;
		long tframe = Long.parseLong(timeframe.substring(0, timeframe.length() - 1));
		
		if (timeframe.endsWith("d")) {
			days = tframe;
		} else if (timeframe.endsWith("h")) {
			hours = tframe;
		} else if (timeframe.endsWith("m")) {
			minutes = tframe;
		}
		long startTimeMilis = (lambda_ts - (((days*24L*60L) + (hours*60L) + minutes) * 60L * 1000L));
		Date tempTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		tempTime.setTime(startTimeMilis);
		String startTimeStr = df.format(tempTime);
		tempTime.setTime(lambda_ts);
		String endTimeStr = df.format(tempTime);
		
		QuerySpec spec = new QuerySpec()
		        .withKeyConditionExpression("id = :v_id and rt between :v_start_dt and :v_end_dt")
		        .withValueMap(new ValueMap()
		        	.withString(":v_id", rc_id)
		        	.withString(":v_start_dt", startTimeStr)
		        	.withString(":v_end_dt", endTimeStr));
		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		ArrayList<String> itemsList = new ArrayList<String>();
		//itemsList.add("timestamp");
		while (iterator.hasNext()) {
		    itemsList.add(iterator.next().toJSON());
		}
		//long lambda_ts_fin = System.currentTimeMillis() - lambda_ts;
		//itemsList.set(0,String.valueOf(lambda_ts_fin));
		return itemsList;
	}

	private void createAlarm(ArrayList<String> events, String ruleInfo, String cr_id, String severity) {
		Date tempTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		tempTime.setTime(lambda_ts);
		String lambdaTimeStr = df.format(tempTime);
		Table table = dynaDB.getTable("AlarmDB");
		
		// Build the item
		Item item = new Item()
		    .withPrimaryKey("id", cr_id)
		    .withString("rt", lambdaTimeStr)
		    .withString("ruleInfo", ruleInfo)
		    .withString("events", events.toString())
		    .withString("severity", severity)
		    .withString("status", "new");
		// Write the item to the table
		PutItemOutcome outcome = table.putItem(item);
		countAlarms++;
		alarms.add(cr_id);
	}
}

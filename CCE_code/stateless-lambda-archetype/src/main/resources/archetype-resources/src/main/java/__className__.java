package ${package};

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    public String handleRequest(List<HashMap<String, String>> eventBatch, Context context) {
	lambda_ts = System.currentTimeMillis();
	LambdaLogger logger = context.getLogger();
	String ret = "";
	//verifVars
    	
        for (HashMap<String, String> eventMap : eventBatch) {
	        String dvchost = eventMap.get("dvchost");
	        String rt = eventMap.get("rt");
        	String eventid = eventMap.get("eventid");
        	//verifCodes
        }
        //condCodes
                
        logger.log("Result: " + ret);
        eventBatch = null;
        
        //return
        
        String className = this.getClass().getName();
        long lambda_ts_fin = System.currentTimeMillis();
        ret = (lambda_ts_fin - lambda_ts) + "," + className + "," + ret;
        return ret;
    }

    private void createAlert(String evt, String dt_id) {
    	Date tempTime = new Date();
    	tempTime.setTime(lambda_ts);
    	String lambdaTimeStr = df.format(tempTime);
    	Table table = dynaDB.getTable("AlertDB");
    	// Build the item
    	Item item = new Item()
 		   .withPrimaryKey("id", dt_id)
 		   .withString("rt", lambdaTimeStr)
 		   .withString("events", evt);
    	// Write the item to the table
    	PutItemOutcome outcome = table.putItem(item);
    }
     
    private void createAlarm(ArrayList<String> events, String ruleInfo, String cr_id, String severity) {
    	Date tempTime = new Date();
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
    }
}


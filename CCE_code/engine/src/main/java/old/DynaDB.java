package old;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DynaDB{
	String tableName;
	final AmazonDynamoDB addb = AmazonDynamoDBClientBuilder.defaultClient();
	
	public DynaDB(String tableName) {
		this.tableName = tableName;
	}
	
	public void addAlert(ArrayList<HashMap<String, String>> params) {
		Map<String, String> ruleInfo = params.get(0);
        Map<String, String> eventMap = params.get(1);
        
        String devName = new String();
        if (!(eventMap.get("dvchost") == null)){
            devName = eventMap.get("dvchost");
        }else if (!(eventMap.get("dvc") == null)) {
            devName = eventMap.get("dvc");
        }
        String evtId = devName+"."+eventMap.get("eventid");
        String rt = eventMap.get("rt");
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDB dynaDB = new DynamoDB(client);
		Table table = dynaDB.getTable(tableName);

		// Build the item
		Item item = new Item()
		    .withPrimaryKey("id", evtId)
		    .withString("timestamp", rt)
		    .withString("ruleInfo", ruleInfo.toString())
		    .withString("eventInfo", eventMap.toString());
		// Write the item to the table
		PutItemOutcome outcome = table.putItem(item);
    }
	
	
	public static void main(String args[]) throws IOException {
		// This will insert manually the 3000 items of dataset.csv and a fixed ruleInfo description.
		ArrayList<HashMap<String, String>> params = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> ruleInfo = new HashMap<String, String>();
		
		ruleInfo.put("title", "CobaltStrike Malleable Amazon browsing traffic profile");
        ruleInfo.put("id", "953b895e-5cc9-454b-b183-7f3db555452e");
        ruleInfo.put("license", "null");
        ruleInfo.put("status", "experimental");
        ruleInfo.put("description", "Detects Malleable Amazon Profile");
        ruleInfo.put("author", "Markus Neis");
        ruleInfo.put("references", "[https://github.com/rsmudge/Malleable-C2-Profiles/blob/master/normal/amazon.profile, https://www.hybrid-analysis.com/sample/ee5eca8648e45e2fea9dac0d920ef1a1792d8690c41ee7f20343de1927cc88b9?environmentId=100]");
        ruleInfo.put("logsource", "{category=proxy, device=squid}");
        ruleInfo.put("falsepositives", "[Unknown]");
        ruleInfo.put("level", "high");
        ruleInfo.put("tags", "[attack.t1102]");
        ruleInfo.put("match", "null");
		
        Path datasetPath = Paths.get("dataset.csv");
		List<String> datasetLines = Files.readAllLines(datasetPath);
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		//Region region = Region.getRegion(Regions.SA_EAST_1);
		//AwsClientBuilder.setRegion(Regions.SA_EAST_1);
		
		DynamoDB dynamoDB = new DynamoDB(client);
		//AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	    //        .withEndpointConfiguration(
	    //        		new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "sa-east-1")).build();
		//DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("AlertDB");
		
		for (int i = 0; i < datasetLines.size(); i++) {
			String[] dsline = datasetLines.get(i).split(",");			
			
			Item item = new Item()
		    	    .withPrimaryKey("id", dsline[0])
		    	    .withString("src_ip", dsline[1])
		    	    .withString("dst_ip", dsline[2])
		    	    .withString("dvchost", dsline[3])
		    	    .withString("dvc", dsline[4])
		    	    .withString("dhost", dsline[5])
		    	    .withString("msg", dsline[6])
		    	    .withString("duser", dsline[7])
		    	    .withString("timestamp", dsline[8])
		    	    .withString("ruleInfo", ruleInfo.toString());
	    	// Write the item to the table
	        PutItemOutcome outcome = table.putItem(item);
		}
		
	}
}
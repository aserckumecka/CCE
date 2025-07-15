package old;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

/**
 * Adriano Serckumecka
 *
 */
public class LambdaInvoke_old {
	InvokeRequest invokeRequest;
	BasicAWSCredentials awsCreds;
	AWSLambda awsLambda;
	
	public LambdaInvoke_old(String event, String lambdaName) {
		setLambdaConfig(lambdaName);
		invokeRequest.setPayload(event);
	}
	
	private void setLambdaConfig(String lambdaName) {
		invokeRequest = new InvokeRequest().withFunctionName(lambdaName);
		awsCreds = new BasicAWSCredentials("AKIAJ4G7YP5CEYE3LGMQ", "I9ms+NWzs+OWkENGNQj+eZDkC5KRO5iFiKQG8hjW");
		awsLambda = AWSLambdaClientBuilder.standard().withRegion(Regions.SA_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	}
	
	public void invokeLambda() {
		try {
			InvokeResult invResult = awsLambda.invoke(invokeRequest);
			System.out.println("Log result: "+invResult.getLogResult());
			ByteBuffer byteBuffer = invResult.getPayload();
			String rawJson = null;
			rawJson = new String(byteBuffer.array(), "UTF-8");
			//System.out.println("Raw Json: "+rawJson);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void deleteTableDynDB(String tableName) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDB dynaDB = new DynamoDB(client);
		Table table = dynaDB.getTable(tableName);
		table.delete(); 
        try {
			table.waitForDelete();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTableDynDB() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "sa-east-1"))
	            .build();

	        DynamoDB dynamoDB = new DynamoDB(client);

	        String tableName = "Movies";

	        try {
	            System.out.println("Attempting to create table; please wait...");
	            Table table = dynamoDB.createTable(tableName,
	                Arrays.asList(new KeySchemaElement("year", KeyType.HASH), // Partition
	                                                                          // key
	                    new KeySchemaElement("title", KeyType.RANGE)), // Sort key
	                Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N),
	                    new AttributeDefinition("title", ScalarAttributeType.S)),
	                new ProvisionedThroughput(10L, 10L));
	            table.waitForActive();
	            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

	        }
	        catch (Exception e) {
	            System.err.println("Unable to create table: ");
	            System.err.println(e.getMessage());
	        }
	}
	
	public static void createTableDynDB(String tableName) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

	    DynamoDB dynamoDB = new DynamoDB(client);
		System.out.println("Attempting to create table; please wait...");
        Table table = dynamoDB.createTable(tableName,
            Arrays.asList(new KeySchemaElement("id", KeyType.HASH), // Partition // key
                new KeySchemaElement("timestamp", KeyType.RANGE)), // Sort key
            Arrays.asList(new AttributeDefinition("eventInfo", ScalarAttributeType.S),
                new AttributeDefinition("ruleInfo", ScalarAttributeType.S)), null);
        try {
			table.waitForActive();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*
		ArrayList<File> proxyEvents = new ArrayList<File>();
		proxyEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy/cce-evt5.json"));
		proxyEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy/cce-evt10.json"));
		proxyEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy/cce-evt25.json"));
		proxyEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy/cce-evt50.json"));
		proxyEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy/cce-evt100.json"));
		proxyEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy/cce-evt200.json"));
		
		ArrayList<File> sysmonEvents = new ArrayList<File>();
		sysmonEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon/cce-evt5.json"));
		sysmonEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon/cce-evt10.json"));
		sysmonEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon/cce-evt25.json"));
		sysmonEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon/cce-evt50.json"));
		sysmonEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon/cce-evt100.json"));
		sysmonEvents.add(new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon/cce-evt200.json"));
		*/
		//File file = new File("/home/adriano/git/slicer/CCE/ruleupload/events/proxy");
		//File file = new File("/home/adriano/git/slicer/CCE/ruleupload/events/sysmon");
		//File[] files = file.listFiles();
		
		/*
		LambdaInvoke_old send = null;
		
		String lambdaName = "cce100_50_1_3008";
		String event = new String();
		try {
        	Path path = Paths.get("/home/adriano/git/slicer/CCE/ruleupload/events/default/100.json");
        	//Path path = Paths.get(sysmonEvents.get(j).getAbsolutePath());
			List<String> lines = Files.readAllLines(path);
			for (String str : lines) {
				event += str;
			}
			//System.out.println(event);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
                
        send = new LambdaInvoke_old(event, lambdaName);
		send.invokeLambda();
		*/
		
		String tableName = "teste";
		createTableDynDB(tableName);
		
		
		
		/*
		for (int j = 0; j < sysmonEvents.size(); j++) {
			System.out.println(sysmonEvents.get(j));
			String event = new String();
	        try {
	        	Path path = Paths.get(sysmonEvents.get(j).getAbsolutePath());
	        	//Path path = Paths.get(sysmonEvents.get(j).getAbsolutePath());
				List<String> lines = Files.readAllLines(path);
				for (String str : lines) {
					event += str;
				}
				//System.out.println(event);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        send = new LambdaInvoke_old(event, lambdaName);
			send.invokeLambda();
			
		}
		*/
	}
}









		//send.createTableDynDB("AlarmDB2");
		
		/*
		// Event in JSON format.
		String jsonString = "{\"dst_ip_hostname\":\"7462d866ef33dddc9c26c085b662980d\",\"related_events\":\"[5a8c11e9840700163e60b9254ee1cab0]\",\"dst_ip\":\"5.79.93.85\",\"plugin_name\":\"cyber-monitor\",\"src_ip\":\"36.156.24.99\",\"priority\":4,\"reliability\":6,\"subcategory\":\"scan\",\"userdata3\":\"\",\"userdata4\":\"\",\"plugin_sid\":\"30004\",\"userdata1\":\"\",\"userdata2\":\"\",\"organization\":\"atos\",\"category\":\"alarm\",\"plugin_id\":\"70000\",\"username\":\"\",\"filename\":\"\",\"backlog_id\":\"dc6ae050053449fea62907a3b1098bba\",\"related_events_info\":{\"a\":{\"date\":\"1554789427\",\"plugin_id\":1001,\"log\":\"ikfwciagosawnzo1nzownybkaxnpzw0tz2l0bgfiihn1cmljyxrhwzeznzddoibbmtoymdaxmje5ojiwxsbfvcbtq0foifbvdgvudglhbcbtu0ggu2nhbibbq2xhc3npzmljyxrpb246ief0dgvtchrlzcbjbmzvcm1hdglvbibmzwfrxsbbuhjpb3jpdhk6idjdihtuq1b9idm2lje1ni4ync45oto0mdi2mcatpia1ljc5ljkzljg1ojiyici=\",\"interface\":\"eth0\",\"dst_ip\":\"5.79.93.85\",\"src_ip\":\"36.156.24.99\",\"userdata7\":null,\"fdate\":\"2019-04-09 05:57:07\",\"userdata8\":null,\"userdata5\":null,\"userdata6\":null,\"userdata9\":null,\"userdata3\":null,\"userdata4\":null,\"userdata1\":null,\"userdata2\":null,\"src_port\":40260,\"plugin_sid\":2001219,\"event_id\":\"5a8c11e9840700163e60b9254ee1cab0\",\"filename\":null,\"organization\":\"atos\",\"dst_port\":22,\"tzone\":\"2.0\",\"device\":\"95.211.159.91\",\"username\":null}},\"protocol\":6,\"risk\":3,\"src_port\":40260,\"sensor\":\"a157560d28d711e7a85b02a5361ffa89\",\"src_ip_hostname\":\"00000000\",\"sid_name\":\"directive_event:  network scan, ssh service discovery activity from src_ip\",\"userdata7\":\"\",\"date\":\"2019-04-09 05:57:07\",\"userdata8\":\"\",\"userdata5\":\"\",\"userdata6\":\"\",\"password\":\"\",\"userdata9\":\"\",\"dst_port\":22,\"event_id\":\"40f56be6bc7b4b7bb83625a3cdaf3ebc\"}";
		
		InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("LambdaTest")
				.withPayload(jsonString);

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAQ5ZEFDXVCV5HZDNR",
				"Tl98nTor1FcfJOIf7k9K2LXJC4n2nP/bC03O6r+b");

		AWSLambda awsLambda = AWSLambdaClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		InvokeResult invokeResult = null;

		try {
			invokeResult = awsLambda.invoke(invokeRequest);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(invokeResult.getStatusCode());

		ByteBuffer byteBuffer = invokeResult.getPayload();

		String rawJson = null;

		try {
			rawJson = new String(byteBuffer.array(), "UTF-8");
		} catch (Exception e) {

		}

		System.out.println(rawJson);
		*/
	
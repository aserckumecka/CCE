package cce.ruleupload;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.devicefarm.model.BillingMethod;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class DynDB {

	
	public static void createTable(String tableName) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDB dynamoDB = new DynamoDB(client);

		try {
            List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
            attributeDefinitions.add(new AttributeDefinition().withAttributeName("id").withAttributeType("S"));
            attributeDefinitions.add(new AttributeDefinition().withAttributeName("rt").withAttributeType("S"));

            List<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
            keySchema.add(new KeySchemaElement().withAttributeName("id").withKeyType(KeyType.HASH)); // Partition
            keySchema.add(new KeySchemaElement().withAttributeName("rt").withKeyType(KeyType.RANGE)); // Sort

            CreateTableRequest request = new CreateTableRequest().withTableName(tableName).withKeySchema(keySchema)
                .withAttributeDefinitions(attributeDefinitions).withProvisionedThroughput(
                    new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));

            System.out.println("Issuing CreateTable request for " + tableName);
            Table table = dynamoDB.createTable(request);

            System.out.println("Waiting for " + tableName + " to be created...this may take a while...");
            table.waitForActive();
        }
        catch (Exception e) {
            System.err.println("CreateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }

	}
	
	public static void deleteTable(String tableName) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable(tableName);
		table.delete();

		try {
			table.waitForDelete();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	
	public static void main(String args[]) {
		String tableName = "AlertDB";
		String command = "aws dynamodb create-table "
				+ "  --table-name " + tableName
				+ "  --attribute-definitions '["
				+ "    {"
				+ "      \"AttributeName\": \"id\","
				+ "      \"AttributeType\": \"S\""
				+ "    },"
				+ "    {"
				+ "      \"AttributeName\": \"rt\","
				+ "      \"AttributeType\": \"S\""
				+ "    },"
				+ "  ]'"
				+ "  --key-schema '["
				+ "    {"
				+ "      \"AttributeName\": \"id\","
				+ "      \"KeyType\": \"HASH\""
				+ "    },"
				+ "    {"
				+ "      \"AttributeName\": \"rt\","
				+ "      \"KeyType\": \"RANGE\""
				+ "    },"
				+ "  ]' "
				+ "  --billing-mode: \"PAY_PER_REQUEST\"";
		deleteTable("AlertDB");
		createTable("AlertDB");
		deleteTable("AlarmDB");
		createTable("AlarmDB");
		//execShellCommand(command, "/home/adriano/");
		//execShellCommand("aws dynamodb update-table --table-name "+tableName+" --billing-mode: \"PAY_PER_REQUEST\"","/home/adriano/");
	}
}

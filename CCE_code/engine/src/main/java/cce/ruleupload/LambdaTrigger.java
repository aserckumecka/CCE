package cce.ruleupload;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.apigateway.model.TooManyRequestsException;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.amazonaws.services.sns.message.HttpException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.yaml.snakeyaml.Yaml;


public class LambdaTrigger implements Runnable{
	String lambdaName; 
	String events;
	int triggerCount=0;
	int blockLTsize=0;
	int triggerGap=0;
	Date tempTime = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	public LambdaTrigger(String lambdaName, String events, int triggerCount, int blockLTsize, int triggerGap) {
		this.lambdaName = lambdaName;
		this.events = events;
		this.triggerCount = triggerCount;
		this.blockLTsize = blockLTsize;
		this.triggerGap = triggerGap;
	}
	
	@Override
	public void run() {
		tempTime.setTime(System.currentTimeMillis());
    	String lambdaTimeStr = df.format(tempTime);
		System.out.println(lambdaTimeStr + ", Triggering: " + lambdaName + ", counter " + triggerCount + 
				", blockSize # / bytes: " + blockLTsize + ", " + events.getBytes().length);
		
		InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(lambdaName)
                .withPayload(events);
        InvokeResult invokeResult = null;

        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.SA_EAST_1).build();

            invokeResult = awsLambda.invoke(invokeRequest);
            String ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

            //write out the return value
            //System.out.println(lambdaName + "-" +"invokeResult: "+ans + " Status Code: " + invokeResult.getStatusCode());
            
        	tempTime.setTime(System.currentTimeMillis());
        	lambdaTimeStr = df.format(tempTime);
            System.out.println(lambdaTimeStr + ", Receiving: " + lambdaName + ", counter " + triggerCount + 
            		", result: " + ans);
            
            ans = ans.substring(1, ans.length()-2);
            String[] ansVec = ans.split(",");
            
            for (int i = 2; i < ansVec.length; i++) {
				String[] result = ansVec[i].split("_");
				Path filePath = Paths.get("devices/"+result[2] + "/" + result[0] + "." + result[1]);
				if (!Files.exists(filePath)) {
				    Files.createFile(filePath);
				}
				String value = new String();
				int result3 = Integer.parseInt(result[3]);
				if(result[2].equals("ins")) {
					String[] resultTemp = ansVec[i+1].split("_");
					double epsD = Double.parseDouble(resultTemp[3]);
					double insD = Double.parseDouble(result[3]);
					value = String.valueOf((insD / epsD) * 100);
					value += "\n";
				}else if(result3 > 0) {
					value = (result3 / (triggerGap/1000)) + "\n";
				}
				Files.write(filePath, value.getBytes(), StandardOpenOption.APPEND);
				//System.out.println(filePath + " with value: " + value);
			}
            
        } catch (ServiceException | IOException e) {
        	System.out.println(lambdaName + ": " + triggerCount);
            System.out.println(e);
        } catch (HttpException | TooManyRequestsException e) {
        	System.out.println(lambdaName + ": " + triggerCount);
            System.out.println(e);
        }
        

        //System.out.println(invokeResult.getStatusCode());
		
	}
}

/*
private static void readConfigDevices() {
	productCondArray = new LinkedHashMap<String, Rule_Condition_Data>();
	Yaml yaml = new Yaml();
	//String projectPath = System.getProperty("user.dir");
	File configFolder = new File("config/"); // YML config files
	if (!configFolder.exists()) {
		configFolder.mkdir();
	}
	File[] yml_config = configFolder.listFiles();
	if (yml_config.length > 0) {
		for (int j = 0; j < yml_config.length; j++) {
			System.out.println(yml_config[j].toString());
			try {
				InputStream inputStream = new FileInputStream(yml_config[j]);
				Reader reader = new InputStreamReader(inputStream);
				LinkedHashMap<String, Object> yamlConfigObj = yaml.load(reader);// from yaml file.
				Rule_Condition_Data rcd = new Rule_Condition_Data();
				//rcd.eps = (int) yamlConfigObj.get("eps");
				//rcd.ins = (int) yamlConfigObj.get("ins");
				rcd.bin = String.valueOf(yamlConfigObj.get("bin"));
				rcd.ver = (int) yamlConfigObj.get("ver");
				rcd.epsR = (float) yamlConfigObj.get("epsR");
				rcd.verR = (float) yamlConfigObj.get("verR");
				rcd.insR = (float) yamlConfigObj.get("insR");
				rcd.conR = (float) yamlConfigObj.get("conR");
				rcd.productName = String.valueOf(yamlConfigObj.get("devname"));
				ArrayList<Integer> ins_values = (ArrayList<Integer>) yamlConfigObj.get("ins_values");
				ArrayList<Integer> eps_values = (ArrayList<Integer>) yamlConfigObj.get("eps_values");

				//TODO calcular avg inserts e EPS baseado nas coletas 
				int total = 0;
				for(int i=0; i<eps_values.size(); i++) {
				    total=total+eps_values.get(i);
				}
				rcd.eps = total/eps_values.size();
				total = 0;
				
				for(int i=0; i<ins_values.size(); i++) {
				    total=total+ins_values.get(i);
				}
				rcd.ins = total/ins_values.size();
				
				rcd.calculateCost();
				productCondArray.put(rcd.productName, rcd);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		productCondArray.put("correlationRules", new Rule_Condition_Data());
	}
}
*/
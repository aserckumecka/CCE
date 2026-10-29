package cce.ruleupload;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.apigateway.model.TooManyRequestsException;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.amazonaws.services.sns.message.HttpException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LambdaTrigger implements Runnable{
	String lambdaName; 
	String events;
	String awsRegion;
	int triggerCount=0;
	int blockLTsize=0;
	int triggerGap=0;
	Date tempTime = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	public LambdaTrigger(String lambdaName, String events, int triggerCount, int blockLTsize, int triggerGap, String awsRegion) {
		this.lambdaName = lambdaName;
		this.events = events;
		this.triggerCount = triggerCount;
		this.blockLTsize = blockLTsize;
		this.triggerGap = triggerGap;
		this.awsRegion = awsRegion;
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
                    .withRegion(awsRegion).build();

            invokeResult = awsLambda.invoke(invokeRequest);
            String ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

        	tempTime.setTime(System.currentTimeMillis());
        	lambdaTimeStr = df.format(tempTime);
            System.out.println(lambdaTimeStr + ", Receiving: " + lambdaName + ", counter " + triggerCount + 
            		", runn.Time: " + ans);
            
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
					if (value.contains("NaN")) {
						value = "0";
					}
					value += "\n";
				}else if(result3 > 0) {
					value = (result3 / (triggerGap/1000)) + "\n";
				}
				Files.write(filePath, value.getBytes(), StandardOpenOption.APPEND);
			}
            
        } catch (ServiceException | IOException e) {
        	System.out.println(lambdaName + ": " + triggerCount);
            System.out.println(e);
        } catch (HttpException | TooManyRequestsException e) {
        	System.out.println(lambdaName + ": " + triggerCount);
            System.out.println(e);
        }
	}
}


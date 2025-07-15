package cce.ruleupload;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;


public class LambdaTriggerCorrelation implements Runnable{
	String lambdaName; 
	long triggerGap;
	int triggerCount;
	Date tempTime = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	public LambdaTriggerCorrelation(String lambdaName, long triggerGap, int triggerCount) {
		this.lambdaName = lambdaName;
		this.triggerGap = (long) triggerGap; //(bincap * 1.10);
		this.triggerCount = triggerCount;
	}
	
	@Override
	public void run() {
		InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(lambdaName)
                .withPayload("{\"test\":\"test\"}");
        InvokeResult invokeResult = null;
        
        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.SA_EAST_1).build();
			
			//while(true) {
				//TestingStatefulLambda tsl = new TestingStatefulLambda();
				//tsl.handleRequest(null);
	            tempTime.setTime(System.currentTimeMillis());
	        	String lambdaTimeStr = df.format(tempTime);
	            System.out.println("\n"+ lambdaTimeStr + ", " + triggerCount + ", Triggering Correlation\n");
            	
	            invokeResult = awsLambda.invoke(invokeRequest);
	            String ans = new String(invokeResult.getPayload().array());

	            long timeSpent = System.currentTimeMillis() - tempTime.getTime();
	            tempTime.setTime(System.currentTimeMillis());
	        	lambdaTimeStr = df.format(tempTime);
	            System.out.println("\n"+ lambdaTimeStr + ", " + triggerCount + ", Correlation result: "+ timeSpent + ", " + ans + "\n");
	            //System.out.println("\n#################################\nCorrelation lambda: invokeResult:\n"+ans+"\n#################################");
				//System.out.println("Correlation lambda: logResult: "+invokeResult.getLogResult());
				//System.out.println("Correlation lambda: getStatusCode: "+invokeResult.getStatusCode());
				//Thread.sleep(bincap);
			//}
        } catch (ServiceException e) {
        	System.out.println(lambdaName + ": " + triggerCount);
        	System.out.println(e);
        }
	}
	
	public static void main(String args[]) {
		Thread thread = new Thread(new LambdaTriggerCorrelation("correlation", 1000, 0));
		thread.start();
	}
}
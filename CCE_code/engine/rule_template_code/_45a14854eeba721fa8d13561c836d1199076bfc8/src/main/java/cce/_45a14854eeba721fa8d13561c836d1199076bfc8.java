package cce;

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

public class _45a14854eeba721fa8d13561c836d1199076bfc8 implements RequestHandler<List<HashMap<String, String>>, String> {
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
        int sgbd_mysql_match = 0;
        int sgbd_mysql_evt = 0;
	ArrayList<String> _8855ffa89cc5af99802784b3e09f5cb87a961701 = new ArrayList<String>();
	ArrayList<String> _1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff = new ArrayList<String>();
	ArrayList<String> _a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65 = new ArrayList<String>();
	ArrayList<String> _501f6fbf66d04cb73f6dee06074226744ac53d01 = new ArrayList<String>();
	ArrayList<String> _51db460bec4109a8806b25413ac382e441f6f0fc = new ArrayList<String>();
	ArrayList<String> _88c888001b589caba79716260013ed12a2c7bd0f = new ArrayList<String>();
	ArrayList<String> _086732454ecca25fdf8c40ce141b3f483c76fed8 = new ArrayList<String>();
	ArrayList<String> _0ba4d32386e1de02f97ea43c8c63ba90671218e6 = new ArrayList<String>();
	ArrayList<String> _a3fcbac1d4a88af67c3f28f2abb216b2929cae41 = new ArrayList<String>();
	ArrayList<String> _1543363c34e0b29094f7345688f40c7963d14e93 = new ArrayList<String>();
	ArrayList<String> _5726646293b17a8e7685acca58be36f4c5a63169 = new ArrayList<String>();
	ArrayList<String> _869b92e50d212a883577d747676e03c197527630 = new ArrayList<String>();
	ArrayList<String> _2fd282a998c1cea0117224bd7022ac651cddb2a0 = new ArrayList<String>();
	ArrayList<String> _ee01889a1db83bde384147426bf71b820489dc91 = new ArrayList<String>();
	ArrayList<String> _9ed44ed82c793239a8d138832d4079f6e1ab204d = new ArrayList<String>();
	ArrayList<String> _b133ab180b1fb60959d04719654385e01e077a4d = new ArrayList<String>();
	ArrayList<String> _f0e853cdbba7fcca08a85c084450255f02d0b03b = new ArrayList<String>();
        int proxy_squid_match = 0;
        int proxy_squid_evt = 0;
	ArrayList<String> _fc7331ca5c15700044340a0d9413d78a21d38c53 = new ArrayList<String>();
	ArrayList<String> _161f8800dd6f42fe6aa3b7e1987965ddfdffbae4 = new ArrayList<String>();
	ArrayList<String> _8358dbde4a339bda436b5cef423084bd62639688 = new ArrayList<String>();
	ArrayList<String> _bed5c994666c80fcc3c17ec20fee3f6d1896062a = new ArrayList<String>();
	ArrayList<String> _f2d66fff4c109665a364295f03830189c94f3dcb = new ArrayList<String>();
	ArrayList<String> _0786198fd896454176d4b89398662f1d39499dcb = new ArrayList<String>();
	ArrayList<String> _1c3411f7a94c3608c50ce2ed96156a760c914419 = new ArrayList<String>();
	ArrayList<String> _a9cd60ab36e252021954410ff19c2c2bf36458b7 = new ArrayList<String>();
	ArrayList<String> _0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f = new ArrayList<String>();
	ArrayList<String> _c3882704403c2c15765bd601f7a048aaff404091 = new ArrayList<String>();
	ArrayList<String> _f122ed273a4bcad4a0c658940b4c7654f279c45f = new ArrayList<String>();
	ArrayList<String> _2246284dd1a6b258b27666358875cfcde34ec1ba = new ArrayList<String>();
	ArrayList<String> _9ae0bef74f955a517cd6c820e3732c528f3a2457 = new ArrayList<String>();
	ArrayList<String> _4abbfce16d018ffee88a2fb362482d42fe60a2a4 = new ArrayList<String>();
	ArrayList<String> _0f54473c7180eeede35ee1ecde143d543f45b041 = new ArrayList<String>();
	ArrayList<String> _0bddf658d6d6cdc030f57b934ae48ca380c54e9a = new ArrayList<String>();
	ArrayList<String> _07e5e9e8ecda5a374553d9d6d8825d2852b01055 = new ArrayList<String>();
	ArrayList<String> _157e5c94c2a5d389ad2d917e45325456565d01a3 = new ArrayList<String>();
        int sgbd_postgresql_match = 0;
        int sgbd_postgresql_evt = 0;
	ArrayList<String> _3255b01aff5e3a409b2ceea41c2027c75bfd32b2 = new ArrayList<String>();
	ArrayList<String> _3d0ae85b773eca3dbae4eed66cc6f975be42617c = new ArrayList<String>();
	ArrayList<String> _59d9fd7f1e371142d53fc3edb44ab8727637264b = new ArrayList<String>();
	ArrayList<String> _7317b822527ddca25b3b2bd1f81d0a7e7e664643 = new ArrayList<String>();
	ArrayList<String> _8f3584071bbbe2f6cd8a53746bbca1fd3e462606 = new ArrayList<String>();
	ArrayList<String> _ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c = new ArrayList<String>();
	ArrayList<String> _af3c197b3295234faf3df6c896d0fcf5e4d65c56 = new ArrayList<String>();
	ArrayList<String> _773b1da9a68e502a99f9ea843689a89902aa5fc7 = new ArrayList<String>();
	ArrayList<String> _6ae545c829e7aa07e363fcf3f089555c3f27417e = new ArrayList<String>();
	ArrayList<String> _8bcde9c575d4a4d7b20df07e47395d398ace53d3 = new ArrayList<String>();
	ArrayList<String> _de4503a22877f834c4220bbae5edbb204de94b5e = new ArrayList<String>();
	ArrayList<String> _3b42753262a535cd129059572fdc9bffbfb3eb5d = new ArrayList<String>();
	ArrayList<String> _a58273dd3c10b0da0e07d5e354f44ea02446a4d5 = new ArrayList<String>();
    	
        for (HashMap<String, String> eventMap : eventBatch) {
	        String dvchost = eventMap.get("dvchost");
	        String rt = eventMap.get("rt");
        	String eventid = eventMap.get("eventid");
        	//verifCodes
		if (dvchost.equals("sgbd.mysql")) {
		    sgbd_mysql_evt++;

			if (eventMap.getOrDefault("duser", "rt").equals("duser162")){
    				_8855ffa89cc5af99802784b3e09f5cb87a961701.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.103.")){
    				_1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser39")){
    				_a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.181.")){
    				_501f6fbf66d04cb73f6dee06074226744ac53d01.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.231.")){
    				_51db460bec4109a8806b25413ac382e441f6f0fc.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.197.")){
    				_88c888001b589caba79716260013ed12a2c7bd0f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost58")){
    				_086732454ecca25fdf8c40ce141b3f483c76fed8.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost255")){
    				_0ba4d32386e1de02f97ea43c8c63ba90671218e6.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost87")){
    				_a3fcbac1d4a88af67c3f28f2abb216b2929cae41.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.96.")){
    				_1543363c34e0b29094f7345688f40c7963d14e93.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost186")){
    				_5726646293b17a8e7685acca58be36f4c5a63169.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.191.")){
    				_869b92e50d212a883577d747676e03c197527630.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.109.")){
    				_2fd282a998c1cea0117224bd7022ac651cddb2a0.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost159")){
    				_ee01889a1db83bde384147426bf71b820489dc91.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost108")){
    				_9ed44ed82c793239a8d138832d4079f6e1ab204d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.49.")){
    				_b133ab180b1fb60959d04719654385e01e077a4d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser15")){
    				_f0e853cdbba7fcca08a85c084450255f02d0b03b.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
		if (dvchost.equals("proxy.squid")) {
		    proxy_squid_evt++;

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost103")){
    				_fc7331ca5c15700044340a0d9413d78a21d38c53.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost180")){
    				_161f8800dd6f42fe6aa3b7e1987965ddfdffbae4.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.39.")){
    				_8358dbde4a339bda436b5cef423084bd62639688.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser218")){
    				_bed5c994666c80fcc3c17ec20fee3f6d1896062a.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser239")){
    				_f2d66fff4c109665a364295f03830189c94f3dcb.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost239")){
    				_0786198fd896454176d4b89398662f1d39499dcb.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser17")){
    				_1c3411f7a94c3608c50ce2ed96156a760c914419.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.176.")){
    				_a9cd60ab36e252021954410ff19c2c2bf36458b7.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser87")){
    				_0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost149")){
    				_c3882704403c2c15765bd601f7a048aaff404091.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost255")){
    				_f122ed273a4bcad4a0c658940b4c7654f279c45f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.119.")){
    				_2246284dd1a6b258b27666358875cfcde34ec1ba.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser201")){
    				_9ae0bef74f955a517cd6c820e3732c528f3a2457.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.68.")){
    				_4abbfce16d018ffee88a2fb362482d42fe60a2a4.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser216")){
    				_0f54473c7180eeede35ee1ecde143d543f45b041.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser134")){
    				_0bddf658d6d6cdc030f57b934ae48ca380c54e9a.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser108")){
    				_07e5e9e8ecda5a374553d9d6d8825d2852b01055.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.230.")){
    				_157e5c94c2a5d389ad2d917e45325456565d01a3.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
		if (dvchost.equals("sgbd.postgresql")) {
		    sgbd_postgresql_evt++;

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.180.")){
    				_3255b01aff5e3a409b2ceea41c2027c75bfd32b2.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost243")){
    				_3d0ae85b773eca3dbae4eed66cc6f975be42617c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost231")){
    				_59d9fd7f1e371142d53fc3edb44ab8727637264b.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser58")){
    				_7317b822527ddca25b3b2bd1f81d0a7e7e664643.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser22")){
    				_8f3584071bbbe2f6cd8a53746bbca1fd3e462606.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser208")){
    				_ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.255.")){
    				_af3c197b3295234faf3df6c896d0fcf5e4d65c56.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.167.")){
    				_773b1da9a68e502a99f9ea843689a89902aa5fc7.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost109")){
    				_6ae545c829e7aa07e363fcf3f089555c3f27417e.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost181")){
    				_8bcde9c575d4a4d7b20df07e47395d398ace53d3.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser49")){
    				_de4503a22877f834c4220bbae5edbb204de94b5e.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser192")){
    				_3b42753262a535cd129059572fdc9bffbfb3eb5d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost192")){
    				_a58273dd3c10b0da0e07d5e354f44ea02446a4d5.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
        }
        //condCodes

		if (_8855ffa89cc5af99802784b3e09f5cb87a961701.size() > 0) {
            for(String evt : _8855ffa89cc5af99802784b3e09f5cb87a961701){
		           createAlert(evt, "_8855ffa89cc5af99802784b3e09f5cb87a961701");
	               sgbd_mysql_match++;
            }
		}

		if (_1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff.size() > 0) {
            for(String evt : _1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff){
		           createAlert(evt, "_1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff");
	               sgbd_mysql_match++;
            }
		}

		if (_a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65.size() > 0) {
            for(String evt : _a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65){
		           createAlert(evt, "_a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65");
	               sgbd_mysql_match++;
            }
		}

		if (_501f6fbf66d04cb73f6dee06074226744ac53d01.size() > 0) {
            for(String evt : _501f6fbf66d04cb73f6dee06074226744ac53d01){
		           createAlert(evt, "_501f6fbf66d04cb73f6dee06074226744ac53d01");
	               sgbd_mysql_match++;
            }
		}

		if (_51db460bec4109a8806b25413ac382e441f6f0fc.size() > 0) {
            for(String evt : _51db460bec4109a8806b25413ac382e441f6f0fc){
		           createAlert(evt, "_51db460bec4109a8806b25413ac382e441f6f0fc");
	               sgbd_mysql_match++;
            }
		}

		if (_88c888001b589caba79716260013ed12a2c7bd0f.size() > 0) {
            for(String evt : _88c888001b589caba79716260013ed12a2c7bd0f){
		           createAlert(evt, "_88c888001b589caba79716260013ed12a2c7bd0f");
	               sgbd_mysql_match++;
            }
		}

		if (_086732454ecca25fdf8c40ce141b3f483c76fed8.size() > 0) {
            for(String evt : _086732454ecca25fdf8c40ce141b3f483c76fed8){
		           createAlert(evt, "_086732454ecca25fdf8c40ce141b3f483c76fed8");
	               sgbd_mysql_match++;
            }
		}

		if (_0ba4d32386e1de02f97ea43c8c63ba90671218e6.size() > 0) {
            for(String evt : _0ba4d32386e1de02f97ea43c8c63ba90671218e6){
		           createAlert(evt, "_0ba4d32386e1de02f97ea43c8c63ba90671218e6");
	               sgbd_mysql_match++;
            }
		}

		if (_a3fcbac1d4a88af67c3f28f2abb216b2929cae41.size() > 0) {
            for(String evt : _a3fcbac1d4a88af67c3f28f2abb216b2929cae41){
		           createAlert(evt, "_a3fcbac1d4a88af67c3f28f2abb216b2929cae41");
	               sgbd_mysql_match++;
            }
		}

		if (_1543363c34e0b29094f7345688f40c7963d14e93.size() > 0) {
            for(String evt : _1543363c34e0b29094f7345688f40c7963d14e93){
		           createAlert(evt, "_1543363c34e0b29094f7345688f40c7963d14e93");
	               sgbd_mysql_match++;
            }
		}

		if (_5726646293b17a8e7685acca58be36f4c5a63169.size() > 0) {
            for(String evt : _5726646293b17a8e7685acca58be36f4c5a63169){
		           createAlert(evt, "_5726646293b17a8e7685acca58be36f4c5a63169");
	               sgbd_mysql_match++;
            }
		}

		if (_869b92e50d212a883577d747676e03c197527630.size() > 0) {
            for(String evt : _869b92e50d212a883577d747676e03c197527630){
		           createAlert(evt, "_869b92e50d212a883577d747676e03c197527630");
	               sgbd_mysql_match++;
            }
		}

		if (_2fd282a998c1cea0117224bd7022ac651cddb2a0.size() > 0) {
            for(String evt : _2fd282a998c1cea0117224bd7022ac651cddb2a0){
		           createAlert(evt, "_2fd282a998c1cea0117224bd7022ac651cddb2a0");
	               sgbd_mysql_match++;
            }
		}

		if (_ee01889a1db83bde384147426bf71b820489dc91.size() > 0) {
            for(String evt : _ee01889a1db83bde384147426bf71b820489dc91){
		           createAlert(evt, "_ee01889a1db83bde384147426bf71b820489dc91");
	               sgbd_mysql_match++;
            }
		}

		if (_9ed44ed82c793239a8d138832d4079f6e1ab204d.size() > 0) {
            for(String evt : _9ed44ed82c793239a8d138832d4079f6e1ab204d){
		           createAlert(evt, "_9ed44ed82c793239a8d138832d4079f6e1ab204d");
	               sgbd_mysql_match++;
            }
		}

		if (_b133ab180b1fb60959d04719654385e01e077a4d.size() > 0) {
            for(String evt : _b133ab180b1fb60959d04719654385e01e077a4d){
		           createAlert(evt, "_b133ab180b1fb60959d04719654385e01e077a4d");
	               sgbd_mysql_match++;
            }
		}

		if (_f0e853cdbba7fcca08a85c084450255f02d0b03b.size() > 0) {
            for(String evt : _f0e853cdbba7fcca08a85c084450255f02d0b03b){
		           createAlert(evt, "_f0e853cdbba7fcca08a85c084450255f02d0b03b");
	               sgbd_mysql_match++;
            }
		}

        ret += "sgbd_mysql_ins_" + sgbd_mysql_match + ",";

        ret += "sgbd_mysql_eps_" + sgbd_mysql_evt + ",";

		if (_fc7331ca5c15700044340a0d9413d78a21d38c53.size() > 0) {
            for(String evt : _fc7331ca5c15700044340a0d9413d78a21d38c53){
		           createAlert(evt, "_fc7331ca5c15700044340a0d9413d78a21d38c53");
	               proxy_squid_match++;
            }
		}

		if (_161f8800dd6f42fe6aa3b7e1987965ddfdffbae4.size() > 0) {
            for(String evt : _161f8800dd6f42fe6aa3b7e1987965ddfdffbae4){
		           createAlert(evt, "_161f8800dd6f42fe6aa3b7e1987965ddfdffbae4");
	               proxy_squid_match++;
            }
		}

		if (_8358dbde4a339bda436b5cef423084bd62639688.size() > 0) {
            for(String evt : _8358dbde4a339bda436b5cef423084bd62639688){
		           createAlert(evt, "_8358dbde4a339bda436b5cef423084bd62639688");
	               proxy_squid_match++;
            }
		}

		if (_bed5c994666c80fcc3c17ec20fee3f6d1896062a.size() > 0) {
            for(String evt : _bed5c994666c80fcc3c17ec20fee3f6d1896062a){
		           createAlert(evt, "_bed5c994666c80fcc3c17ec20fee3f6d1896062a");
	               proxy_squid_match++;
            }
		}

		if (_f2d66fff4c109665a364295f03830189c94f3dcb.size() > 0) {
            for(String evt : _f2d66fff4c109665a364295f03830189c94f3dcb){
		           createAlert(evt, "_f2d66fff4c109665a364295f03830189c94f3dcb");
	               proxy_squid_match++;
            }
		}

		if (_0786198fd896454176d4b89398662f1d39499dcb.size() > 0) {
            for(String evt : _0786198fd896454176d4b89398662f1d39499dcb){
		           createAlert(evt, "_0786198fd896454176d4b89398662f1d39499dcb");
	               proxy_squid_match++;
            }
		}

		if (_1c3411f7a94c3608c50ce2ed96156a760c914419.size() > 0) {
            for(String evt : _1c3411f7a94c3608c50ce2ed96156a760c914419){
		           createAlert(evt, "_1c3411f7a94c3608c50ce2ed96156a760c914419");
	               proxy_squid_match++;
            }
		}

		if (_a9cd60ab36e252021954410ff19c2c2bf36458b7.size() > 0) {
            for(String evt : _a9cd60ab36e252021954410ff19c2c2bf36458b7){
		           createAlert(evt, "_a9cd60ab36e252021954410ff19c2c2bf36458b7");
	               proxy_squid_match++;
            }
		}

		if (_0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f.size() > 0) {
            for(String evt : _0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f){
		           createAlert(evt, "_0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f");
	               proxy_squid_match++;
            }
		}

		if (_c3882704403c2c15765bd601f7a048aaff404091.size() > 0) {
            for(String evt : _c3882704403c2c15765bd601f7a048aaff404091){
		           createAlert(evt, "_c3882704403c2c15765bd601f7a048aaff404091");
	               proxy_squid_match++;
            }
		}

		if (_f122ed273a4bcad4a0c658940b4c7654f279c45f.size() > 0) {
            for(String evt : _f122ed273a4bcad4a0c658940b4c7654f279c45f){
		           createAlert(evt, "_f122ed273a4bcad4a0c658940b4c7654f279c45f");
	               proxy_squid_match++;
            }
		}

		if (_2246284dd1a6b258b27666358875cfcde34ec1ba.size() > 0) {
            for(String evt : _2246284dd1a6b258b27666358875cfcde34ec1ba){
		           createAlert(evt, "_2246284dd1a6b258b27666358875cfcde34ec1ba");
	               proxy_squid_match++;
            }
		}

		if (_9ae0bef74f955a517cd6c820e3732c528f3a2457.size() > 0) {
            for(String evt : _9ae0bef74f955a517cd6c820e3732c528f3a2457){
		           createAlert(evt, "_9ae0bef74f955a517cd6c820e3732c528f3a2457");
	               proxy_squid_match++;
            }
		}

		if (_4abbfce16d018ffee88a2fb362482d42fe60a2a4.size() > 0) {
            for(String evt : _4abbfce16d018ffee88a2fb362482d42fe60a2a4){
		           createAlert(evt, "_4abbfce16d018ffee88a2fb362482d42fe60a2a4");
	               proxy_squid_match++;
            }
		}

		if (_0f54473c7180eeede35ee1ecde143d543f45b041.size() > 0) {
            for(String evt : _0f54473c7180eeede35ee1ecde143d543f45b041){
		           createAlert(evt, "_0f54473c7180eeede35ee1ecde143d543f45b041");
	               proxy_squid_match++;
            }
		}

		if (_0bddf658d6d6cdc030f57b934ae48ca380c54e9a.size() > 0) {
            for(String evt : _0bddf658d6d6cdc030f57b934ae48ca380c54e9a){
		           createAlert(evt, "_0bddf658d6d6cdc030f57b934ae48ca380c54e9a");
	               proxy_squid_match++;
            }
		}

		if (_07e5e9e8ecda5a374553d9d6d8825d2852b01055.size() > 0) {
            for(String evt : _07e5e9e8ecda5a374553d9d6d8825d2852b01055){
		           createAlert(evt, "_07e5e9e8ecda5a374553d9d6d8825d2852b01055");
	               proxy_squid_match++;
            }
		}

		if (_157e5c94c2a5d389ad2d917e45325456565d01a3.size() > 0) {
            for(String evt : _157e5c94c2a5d389ad2d917e45325456565d01a3){
		           createAlert(evt, "_157e5c94c2a5d389ad2d917e45325456565d01a3");
	               proxy_squid_match++;
            }
		}

        ret += "proxy_squid_ins_" + proxy_squid_match + ",";

        ret += "proxy_squid_eps_" + proxy_squid_evt + ",";

		if (_3255b01aff5e3a409b2ceea41c2027c75bfd32b2.size() > 0) {
            for(String evt : _3255b01aff5e3a409b2ceea41c2027c75bfd32b2){
		           createAlert(evt, "_3255b01aff5e3a409b2ceea41c2027c75bfd32b2");
	               sgbd_postgresql_match++;
            }
		}

		if (_3d0ae85b773eca3dbae4eed66cc6f975be42617c.size() > 0) {
            for(String evt : _3d0ae85b773eca3dbae4eed66cc6f975be42617c){
		           createAlert(evt, "_3d0ae85b773eca3dbae4eed66cc6f975be42617c");
	               sgbd_postgresql_match++;
            }
		}

		if (_59d9fd7f1e371142d53fc3edb44ab8727637264b.size() > 0) {
            for(String evt : _59d9fd7f1e371142d53fc3edb44ab8727637264b){
		           createAlert(evt, "_59d9fd7f1e371142d53fc3edb44ab8727637264b");
	               sgbd_postgresql_match++;
            }
		}

		if (_7317b822527ddca25b3b2bd1f81d0a7e7e664643.size() > 0) {
            for(String evt : _7317b822527ddca25b3b2bd1f81d0a7e7e664643){
		           createAlert(evt, "_7317b822527ddca25b3b2bd1f81d0a7e7e664643");
	               sgbd_postgresql_match++;
            }
		}

		if (_8f3584071bbbe2f6cd8a53746bbca1fd3e462606.size() > 0) {
            for(String evt : _8f3584071bbbe2f6cd8a53746bbca1fd3e462606){
		           createAlert(evt, "_8f3584071bbbe2f6cd8a53746bbca1fd3e462606");
	               sgbd_postgresql_match++;
            }
		}

		if (_ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c.size() > 0) {
            for(String evt : _ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c){
		           createAlert(evt, "_ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c");
	               sgbd_postgresql_match++;
            }
		}

		if (_af3c197b3295234faf3df6c896d0fcf5e4d65c56.size() > 0) {
            for(String evt : _af3c197b3295234faf3df6c896d0fcf5e4d65c56){
		           createAlert(evt, "_af3c197b3295234faf3df6c896d0fcf5e4d65c56");
	               sgbd_postgresql_match++;
            }
		}

		if (_773b1da9a68e502a99f9ea843689a89902aa5fc7.size() > 0) {
            for(String evt : _773b1da9a68e502a99f9ea843689a89902aa5fc7){
		           createAlert(evt, "_773b1da9a68e502a99f9ea843689a89902aa5fc7");
	               sgbd_postgresql_match++;
            }
		}

		if (_6ae545c829e7aa07e363fcf3f089555c3f27417e.size() > 0) {
            for(String evt : _6ae545c829e7aa07e363fcf3f089555c3f27417e){
		           createAlert(evt, "_6ae545c829e7aa07e363fcf3f089555c3f27417e");
	               sgbd_postgresql_match++;
            }
		}

		if (_8bcde9c575d4a4d7b20df07e47395d398ace53d3.size() > 0) {
            for(String evt : _8bcde9c575d4a4d7b20df07e47395d398ace53d3){
		           createAlert(evt, "_8bcde9c575d4a4d7b20df07e47395d398ace53d3");
	               sgbd_postgresql_match++;
            }
		}

		if (_de4503a22877f834c4220bbae5edbb204de94b5e.size() > 0) {
            for(String evt : _de4503a22877f834c4220bbae5edbb204de94b5e){
		           createAlert(evt, "_de4503a22877f834c4220bbae5edbb204de94b5e");
	               sgbd_postgresql_match++;
            }
		}

		if (_3b42753262a535cd129059572fdc9bffbfb3eb5d.size() > 0) {
            for(String evt : _3b42753262a535cd129059572fdc9bffbfb3eb5d){
		           createAlert(evt, "_3b42753262a535cd129059572fdc9bffbfb3eb5d");
	               sgbd_postgresql_match++;
            }
		}

		if (_a58273dd3c10b0da0e07d5e354f44ea02446a4d5.size() > 0) {
            for(String evt : _a58273dd3c10b0da0e07d5e354f44ea02446a4d5){
		           createAlert(evt, "_a58273dd3c10b0da0e07d5e354f44ea02446a4d5");
	               sgbd_postgresql_match++;
            }
		}

        ret += "sgbd_postgresql_ins_" + sgbd_postgresql_match + ",";

        ret += "sgbd_postgresql_eps_" + sgbd_postgresql_evt + ",";
                
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


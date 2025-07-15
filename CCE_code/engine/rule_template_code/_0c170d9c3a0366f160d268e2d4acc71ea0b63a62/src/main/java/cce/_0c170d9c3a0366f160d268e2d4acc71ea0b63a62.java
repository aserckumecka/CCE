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

public class _0c170d9c3a0366f160d268e2d4acc71ea0b63a62 implements RequestHandler<List<HashMap<String, String>>, String> {
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
        int ids_snort_match = 0;
        int ids_snort_evt = 0;
	ArrayList<String> _f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8 = new ArrayList<String>();
	ArrayList<String> _cab2d644b46414f5594a29f9630bf29d7c5f8ef5 = new ArrayList<String>();
	ArrayList<String> _d354aae734486401f4b42390393885ac734b0e6f = new ArrayList<String>();
	ArrayList<String> _13e745f13cc776dcf436ad73e8c4bc912deb4848 = new ArrayList<String>();
	ArrayList<String> _1bd59355994f0a7a54b49494effb8ac4f155630c = new ArrayList<String>();
	ArrayList<String> _1526f8cb2d2890511c6303bd8ed97b84bf707141 = new ArrayList<String>();
	ArrayList<String> _87bafdd10cd08b68468ced3523e25c9d0735547e = new ArrayList<String>();
	ArrayList<String> _afe0256f77b115c577bd6dd0e5b28a76544b1ef9 = new ArrayList<String>();
	ArrayList<String> _6903320f6fef6d3723340b6a2f69ea95cd32cf52 = new ArrayList<String>();
	ArrayList<String> _39d5ec83dbd5ef05dd34ab9c80b066ce882742fc = new ArrayList<String>();
	ArrayList<String> _786817da8265ff4a85c201b2088a16a5ce8f6512 = new ArrayList<String>();
	ArrayList<String> _a95d39176f2c4d99ade715db65c734605311a483 = new ArrayList<String>();
	ArrayList<String> _1a649561d8a6ae73435872933f485f61620ac3bf = new ArrayList<String>();
	ArrayList<String> _79b519015241b2d44baef79a0a49b3f828658dda = new ArrayList<String>();
	ArrayList<String> _8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726 = new ArrayList<String>();
	ArrayList<String> _9d95f5f52322eca9116657c752589d1598ea0f39 = new ArrayList<String>();
	ArrayList<String> _43e291d7f935d7ed0f19203a3fda31b8280b1915 = new ArrayList<String>();
	ArrayList<String> _9843e22e87a3e2e033823c108365611fd0f0f251 = new ArrayList<String>();
	ArrayList<String> _fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505 = new ArrayList<String>();
	ArrayList<String> _affcbe9bf7432434433f165b4385a9b920f090b3 = new ArrayList<String>();
	ArrayList<String> _e4fa7e6187c45103d71127bf9c37e7f57a77f40c = new ArrayList<String>();
	ArrayList<String> _ff5295a080360ac57b6ab26b62317ceb4a75145a = new ArrayList<String>();
	ArrayList<String> _c5220a05e1b8d33bc5fe13979bff72bce2f79bf6 = new ArrayList<String>();
	ArrayList<String> _a0f744c232cc5faf1c8304e5deb90423da3c09fa = new ArrayList<String>();
	ArrayList<String> _400ea6fef3e51b365f858cdfe024c89a704df2b2 = new ArrayList<String>();
	ArrayList<String> _33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c = new ArrayList<String>();
	ArrayList<String> _db2bd5c92ce2eb63f14cb78340626d37c6669974 = new ArrayList<String>();
	ArrayList<String> _398515f6c6d39388a88d617e8a8701e6f65cadb6 = new ArrayList<String>();
        int firewall_sonicwall_match = 0;
        int firewall_sonicwall_evt = 0;
	ArrayList<String> _8e061f420df9595617803ef851d023f6e5c661a5 = new ArrayList<String>();
	ArrayList<String> _e0d76b4ab67c2f46854c642eedc1ac48f09c3578 = new ArrayList<String>();
	ArrayList<String> _779047a7a1bf76f478da117672240203a7b763cd = new ArrayList<String>();
	ArrayList<String> _4ab473aa34a89a8198083b0ed8ff0db10cf69b8a = new ArrayList<String>();
	ArrayList<String> _a0afd6133d8d279d6bd17ade6aba98d0bb8380c6 = new ArrayList<String>();
	ArrayList<String> _2834f7032e1a8bdd49aeb1ca96ca953301ff28d5 = new ArrayList<String>();
	ArrayList<String> _bddaa2e48a193e0a4ed625186ce2eb3caee6671d = new ArrayList<String>();
	ArrayList<String> _b22a522b614bc302600ba1ca1b277f641980a62c = new ArrayList<String>();
	ArrayList<String> _3c29fb29b1c2b10e3ea400c996f465799d1831aa = new ArrayList<String>();
	ArrayList<String> _1bec5e965b6331438eab50198df239f8bf91101f = new ArrayList<String>();
	ArrayList<String> _2d3645438bff6890232cab9c0c4dc754d5bfb7c4 = new ArrayList<String>();
	ArrayList<String> _2a541f25c3bd5597e9a1a858e0a2bb8a4b186562 = new ArrayList<String>();
	ArrayList<String> _d2727c1761e69bce90895f2e3f24f3eeab5bb859 = new ArrayList<String>();
	ArrayList<String> _cfeebcdea078cb4ce9602c456040fb85ba6a672c = new ArrayList<String>();
	ArrayList<String> _b07720fc42e2ccdc44d37a3aafffba6ed50da46d = new ArrayList<String>();
	ArrayList<String> _6955fa5aa1e2d5d595597c6300df5ae7e5e78b96 = new ArrayList<String>();
	ArrayList<String> _729e1e034a67dc4cc06033eacb45bcee73ab7a38 = new ArrayList<String>();
	ArrayList<String> _ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5 = new ArrayList<String>();
	ArrayList<String> _19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3 = new ArrayList<String>();
	ArrayList<String> _532071fc551da07f8c314f0cd0e7e749620e3240 = new ArrayList<String>();
	ArrayList<String> _2ab2471852138580321e2768eb86006313ddd34d = new ArrayList<String>();
	ArrayList<String> _083d95bb2055cb63ae6e0bc7044065055ff12365 = new ArrayList<String>();
	ArrayList<String> _5441f73c76eb60aeaa8f896a16a991c825b8b0c5 = new ArrayList<String>();
	ArrayList<String> _c95d98b19dfc53a078269b7dd33acc21d9b0918f = new ArrayList<String>();
    	
        for (HashMap<String, String> eventMap : eventBatch) {
	        String dvchost = eventMap.get("dvchost");
	        String rt = eventMap.get("rt");
        	String eventid = eventMap.get("eventid");
        	//verifCodes
		if (dvchost.equals("ids.snort")) {
		    ids_snort_evt++;

			if (eventMap.getOrDefault("duser", "rt").equals("duser183")){
    				_f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser103")){
    				_cab2d644b46414f5594a29f9630bf29d7c5f8ef5.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser180")){
    				_d354aae734486401f4b42390393885ac734b0e6f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.222.")){
    				_13e745f13cc776dcf436ad73e8c4bc912deb4848.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.239.")){
    				_1bd59355994f0a7a54b49494effb8ac4f155630c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser181")){
    				_1526f8cb2d2890511c6303bd8ed97b84bf707141.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost17")){
    				_87bafdd10cd08b68468ced3523e25c9d0735547e.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser243")){
    				_afe0256f77b115c577bd6dd0e5b28a76544b1ef9.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser176")){
    				_6903320f6fef6d3723340b6a2f69ea95cd32cf52.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost176")){
    				_39d5ec83dbd5ef05dd34ab9c80b066ce882742fc.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser197")){
    				_786817da8265ff4a85c201b2088a16a5ce8f6512.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.69.")){
    				_a95d39176f2c4d99ade715db65c734605311a483.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser224")){
    				_1a649561d8a6ae73435872933f485f61620ac3bf.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost46")){
    				_79b519015241b2d44baef79a0a49b3f828658dda.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser11")){
    				_8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost208")){
    				_9d95f5f52322eca9116657c752589d1598ea0f39.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser96")){
    				_43e291d7f935d7ed0f19203a3fda31b8280b1915.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost96")){
    				_9843e22e87a3e2e033823c108365611fd0f0f251.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.187.")){
    				_fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser6")){
    				_affcbe9bf7432434433f165b4385a9b920f090b3.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser167")){
    				_e4fa7e6187c45103d71127bf9c37e7f57a77f40c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost167")){
    				_ff5295a080360ac57b6ab26b62317ceb4a75145a.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.201.")){
    				_c5220a05e1b8d33bc5fe13979bff72bce2f79bf6.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost191")){
    				_a0f744c232cc5faf1c8304e5deb90423da3c09fa.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.216.")){
    				_400ea6fef3e51b365f858cdfe024c89a704df2b2.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost216")){
    				_33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost134")){
    				_db2bd5c92ce2eb63f14cb78340626d37c6669974.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser159")){
    				_398515f6c6d39388a88d617e8a8701e6f65cadb6.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
		if (dvchost.equals("firewall.sonicwall")) {
		    firewall_sonicwall_evt++;

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.218.")){
    				_8e061f420df9595617803ef851d023f6e5c661a5.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost197")){
    				_e0d76b4ab67c2f46854c642eedc1ac48f09c3578.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser69")){
    				_779047a7a1bf76f478da117672240203a7b763cd.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.224.")){
    				_4ab473aa34a89a8198083b0ed8ff0db10cf69b8a.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser111")){
    				_a0afd6133d8d279d6bd17ade6aba98d0bb8380c6.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.46.")){
    				_2834f7032e1a8bdd49aeb1ca96ca953301ff28d5.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser46")){
    				_bddaa2e48a193e0a4ed625186ce2eb3caee6671d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.207.")){
    				_b22a522b614bc302600ba1ca1b277f641980a62c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost207")){
    				_3c29fb29b1c2b10e3ea400c996f465799d1831aa.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.255.")){
    				_1bec5e965b6331438eab50198df239f8bf91101f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.87.")){
    				_2d3645438bff6890232cab9c0c4dc754d5bfb7c4.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost11")){
    				_2a541f25c3bd5597e9a1a858e0a2bb8a4b186562.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser149")){
    				_d2727c1761e69bce90895f2e3f24f3eeab5bb859.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.6.")){
    				_cfeebcdea078cb4ce9602c456040fb85ba6a672c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost17")){
    				_b07720fc42e2ccdc44d37a3aafffba6ed50da46d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.199.")){
    				_6955fa5aa1e2d5d595597c6300df5ae7e5e78b96.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser199")){
    				_729e1e034a67dc4cc06033eacb45bcee73ab7a38.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost68")){
    				_ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.134.")){
    				_19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.159.")){
    				_532071fc551da07f8c314f0cd0e7e749620e3240.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser181")){
    				_2ab2471852138580321e2768eb86006313ddd34d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser230")){
    				_083d95bb2055cb63ae6e0bc7044065055ff12365.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost49")){
    				_5441f73c76eb60aeaa8f896a16a991c825b8b0c5.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.192.")){
    				_c95d98b19dfc53a078269b7dd33acc21d9b0918f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
        }
        //condCodes

		if (_f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8.size() > 0) {
            for(String evt : _f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8){
		           createAlert(evt, "_f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8");
	               ids_snort_match++;
            }
		}

		if (_cab2d644b46414f5594a29f9630bf29d7c5f8ef5.size() > 0) {
            for(String evt : _cab2d644b46414f5594a29f9630bf29d7c5f8ef5){
		           createAlert(evt, "_cab2d644b46414f5594a29f9630bf29d7c5f8ef5");
	               ids_snort_match++;
            }
		}

		if (_d354aae734486401f4b42390393885ac734b0e6f.size() > 0) {
            for(String evt : _d354aae734486401f4b42390393885ac734b0e6f){
		           createAlert(evt, "_d354aae734486401f4b42390393885ac734b0e6f");
	               ids_snort_match++;
            }
		}

		if (_13e745f13cc776dcf436ad73e8c4bc912deb4848.size() > 0) {
            for(String evt : _13e745f13cc776dcf436ad73e8c4bc912deb4848){
		           createAlert(evt, "_13e745f13cc776dcf436ad73e8c4bc912deb4848");
	               ids_snort_match++;
            }
		}

		if (_1bd59355994f0a7a54b49494effb8ac4f155630c.size() > 0) {
            for(String evt : _1bd59355994f0a7a54b49494effb8ac4f155630c){
		           createAlert(evt, "_1bd59355994f0a7a54b49494effb8ac4f155630c");
	               ids_snort_match++;
            }
		}

		if (_1526f8cb2d2890511c6303bd8ed97b84bf707141.size() > 0) {
            for(String evt : _1526f8cb2d2890511c6303bd8ed97b84bf707141){
		           createAlert(evt, "_1526f8cb2d2890511c6303bd8ed97b84bf707141");
	               ids_snort_match++;
            }
		}

		if (_87bafdd10cd08b68468ced3523e25c9d0735547e.size() > 0) {
            for(String evt : _87bafdd10cd08b68468ced3523e25c9d0735547e){
		           createAlert(evt, "_87bafdd10cd08b68468ced3523e25c9d0735547e");
	               ids_snort_match++;
            }
		}

		if (_afe0256f77b115c577bd6dd0e5b28a76544b1ef9.size() > 0) {
            for(String evt : _afe0256f77b115c577bd6dd0e5b28a76544b1ef9){
		           createAlert(evt, "_afe0256f77b115c577bd6dd0e5b28a76544b1ef9");
	               ids_snort_match++;
            }
		}

		if (_6903320f6fef6d3723340b6a2f69ea95cd32cf52.size() > 0) {
            for(String evt : _6903320f6fef6d3723340b6a2f69ea95cd32cf52){
		           createAlert(evt, "_6903320f6fef6d3723340b6a2f69ea95cd32cf52");
	               ids_snort_match++;
            }
		}

		if (_39d5ec83dbd5ef05dd34ab9c80b066ce882742fc.size() > 0) {
            for(String evt : _39d5ec83dbd5ef05dd34ab9c80b066ce882742fc){
		           createAlert(evt, "_39d5ec83dbd5ef05dd34ab9c80b066ce882742fc");
	               ids_snort_match++;
            }
		}

		if (_786817da8265ff4a85c201b2088a16a5ce8f6512.size() > 0) {
            for(String evt : _786817da8265ff4a85c201b2088a16a5ce8f6512){
		           createAlert(evt, "_786817da8265ff4a85c201b2088a16a5ce8f6512");
	               ids_snort_match++;
            }
		}

		if (_a95d39176f2c4d99ade715db65c734605311a483.size() > 0) {
            for(String evt : _a95d39176f2c4d99ade715db65c734605311a483){
		           createAlert(evt, "_a95d39176f2c4d99ade715db65c734605311a483");
	               ids_snort_match++;
            }
		}

		if (_1a649561d8a6ae73435872933f485f61620ac3bf.size() > 0) {
            for(String evt : _1a649561d8a6ae73435872933f485f61620ac3bf){
		           createAlert(evt, "_1a649561d8a6ae73435872933f485f61620ac3bf");
	               ids_snort_match++;
            }
		}

		if (_79b519015241b2d44baef79a0a49b3f828658dda.size() > 0) {
            for(String evt : _79b519015241b2d44baef79a0a49b3f828658dda){
		           createAlert(evt, "_79b519015241b2d44baef79a0a49b3f828658dda");
	               ids_snort_match++;
            }
		}

		if (_8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726.size() > 0) {
            for(String evt : _8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726){
		           createAlert(evt, "_8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726");
	               ids_snort_match++;
            }
		}

		if (_9d95f5f52322eca9116657c752589d1598ea0f39.size() > 0) {
            for(String evt : _9d95f5f52322eca9116657c752589d1598ea0f39){
		           createAlert(evt, "_9d95f5f52322eca9116657c752589d1598ea0f39");
	               ids_snort_match++;
            }
		}

		if (_43e291d7f935d7ed0f19203a3fda31b8280b1915.size() > 0) {
            for(String evt : _43e291d7f935d7ed0f19203a3fda31b8280b1915){
		           createAlert(evt, "_43e291d7f935d7ed0f19203a3fda31b8280b1915");
	               ids_snort_match++;
            }
		}

		if (_9843e22e87a3e2e033823c108365611fd0f0f251.size() > 0) {
            for(String evt : _9843e22e87a3e2e033823c108365611fd0f0f251){
		           createAlert(evt, "_9843e22e87a3e2e033823c108365611fd0f0f251");
	               ids_snort_match++;
            }
		}

		if (_fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505.size() > 0) {
            for(String evt : _fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505){
		           createAlert(evt, "_fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505");
	               ids_snort_match++;
            }
		}

		if (_affcbe9bf7432434433f165b4385a9b920f090b3.size() > 0) {
            for(String evt : _affcbe9bf7432434433f165b4385a9b920f090b3){
		           createAlert(evt, "_affcbe9bf7432434433f165b4385a9b920f090b3");
	               ids_snort_match++;
            }
		}

		if (_e4fa7e6187c45103d71127bf9c37e7f57a77f40c.size() > 0) {
            for(String evt : _e4fa7e6187c45103d71127bf9c37e7f57a77f40c){
		           createAlert(evt, "_e4fa7e6187c45103d71127bf9c37e7f57a77f40c");
	               ids_snort_match++;
            }
		}

		if (_ff5295a080360ac57b6ab26b62317ceb4a75145a.size() > 0) {
            for(String evt : _ff5295a080360ac57b6ab26b62317ceb4a75145a){
		           createAlert(evt, "_ff5295a080360ac57b6ab26b62317ceb4a75145a");
	               ids_snort_match++;
            }
		}

		if (_c5220a05e1b8d33bc5fe13979bff72bce2f79bf6.size() > 0) {
            for(String evt : _c5220a05e1b8d33bc5fe13979bff72bce2f79bf6){
		           createAlert(evt, "_c5220a05e1b8d33bc5fe13979bff72bce2f79bf6");
	               ids_snort_match++;
            }
		}

		if (_a0f744c232cc5faf1c8304e5deb90423da3c09fa.size() > 0) {
            for(String evt : _a0f744c232cc5faf1c8304e5deb90423da3c09fa){
		           createAlert(evt, "_a0f744c232cc5faf1c8304e5deb90423da3c09fa");
	               ids_snort_match++;
            }
		}

		if (_400ea6fef3e51b365f858cdfe024c89a704df2b2.size() > 0) {
            for(String evt : _400ea6fef3e51b365f858cdfe024c89a704df2b2){
		           createAlert(evt, "_400ea6fef3e51b365f858cdfe024c89a704df2b2");
	               ids_snort_match++;
            }
		}

		if (_33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c.size() > 0) {
            for(String evt : _33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c){
		           createAlert(evt, "_33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c");
	               ids_snort_match++;
            }
		}

		if (_db2bd5c92ce2eb63f14cb78340626d37c6669974.size() > 0) {
            for(String evt : _db2bd5c92ce2eb63f14cb78340626d37c6669974){
		           createAlert(evt, "_db2bd5c92ce2eb63f14cb78340626d37c6669974");
	               ids_snort_match++;
            }
		}

		if (_398515f6c6d39388a88d617e8a8701e6f65cadb6.size() > 0) {
            for(String evt : _398515f6c6d39388a88d617e8a8701e6f65cadb6){
		           createAlert(evt, "_398515f6c6d39388a88d617e8a8701e6f65cadb6");
	               ids_snort_match++;
            }
		}

        ret += "ids_snort_ins_" + ids_snort_match + ",";

        ret += "ids_snort_eps_" + ids_snort_evt + ",";

		if (_8e061f420df9595617803ef851d023f6e5c661a5.size() > 0) {
            for(String evt : _8e061f420df9595617803ef851d023f6e5c661a5){
		           createAlert(evt, "_8e061f420df9595617803ef851d023f6e5c661a5");
	               firewall_sonicwall_match++;
            }
		}

		if (_e0d76b4ab67c2f46854c642eedc1ac48f09c3578.size() > 0) {
            for(String evt : _e0d76b4ab67c2f46854c642eedc1ac48f09c3578){
		           createAlert(evt, "_e0d76b4ab67c2f46854c642eedc1ac48f09c3578");
	               firewall_sonicwall_match++;
            }
		}

		if (_779047a7a1bf76f478da117672240203a7b763cd.size() > 0) {
            for(String evt : _779047a7a1bf76f478da117672240203a7b763cd){
		           createAlert(evt, "_779047a7a1bf76f478da117672240203a7b763cd");
	               firewall_sonicwall_match++;
            }
		}

		if (_4ab473aa34a89a8198083b0ed8ff0db10cf69b8a.size() > 0) {
            for(String evt : _4ab473aa34a89a8198083b0ed8ff0db10cf69b8a){
		           createAlert(evt, "_4ab473aa34a89a8198083b0ed8ff0db10cf69b8a");
	               firewall_sonicwall_match++;
            }
		}

		if (_a0afd6133d8d279d6bd17ade6aba98d0bb8380c6.size() > 0) {
            for(String evt : _a0afd6133d8d279d6bd17ade6aba98d0bb8380c6){
		           createAlert(evt, "_a0afd6133d8d279d6bd17ade6aba98d0bb8380c6");
	               firewall_sonicwall_match++;
            }
		}

		if (_2834f7032e1a8bdd49aeb1ca96ca953301ff28d5.size() > 0) {
            for(String evt : _2834f7032e1a8bdd49aeb1ca96ca953301ff28d5){
		           createAlert(evt, "_2834f7032e1a8bdd49aeb1ca96ca953301ff28d5");
	               firewall_sonicwall_match++;
            }
		}

		if (_bddaa2e48a193e0a4ed625186ce2eb3caee6671d.size() > 0) {
            for(String evt : _bddaa2e48a193e0a4ed625186ce2eb3caee6671d){
		           createAlert(evt, "_bddaa2e48a193e0a4ed625186ce2eb3caee6671d");
	               firewall_sonicwall_match++;
            }
		}

		if (_b22a522b614bc302600ba1ca1b277f641980a62c.size() > 0) {
            for(String evt : _b22a522b614bc302600ba1ca1b277f641980a62c){
		           createAlert(evt, "_b22a522b614bc302600ba1ca1b277f641980a62c");
	               firewall_sonicwall_match++;
            }
		}

		if (_3c29fb29b1c2b10e3ea400c996f465799d1831aa.size() > 0) {
            for(String evt : _3c29fb29b1c2b10e3ea400c996f465799d1831aa){
		           createAlert(evt, "_3c29fb29b1c2b10e3ea400c996f465799d1831aa");
	               firewall_sonicwall_match++;
            }
		}

		if (_1bec5e965b6331438eab50198df239f8bf91101f.size() > 0) {
            for(String evt : _1bec5e965b6331438eab50198df239f8bf91101f){
		           createAlert(evt, "_1bec5e965b6331438eab50198df239f8bf91101f");
	               firewall_sonicwall_match++;
            }
		}

		if (_2d3645438bff6890232cab9c0c4dc754d5bfb7c4.size() > 0) {
            for(String evt : _2d3645438bff6890232cab9c0c4dc754d5bfb7c4){
		           createAlert(evt, "_2d3645438bff6890232cab9c0c4dc754d5bfb7c4");
	               firewall_sonicwall_match++;
            }
		}

		if (_2a541f25c3bd5597e9a1a858e0a2bb8a4b186562.size() > 0) {
            for(String evt : _2a541f25c3bd5597e9a1a858e0a2bb8a4b186562){
		           createAlert(evt, "_2a541f25c3bd5597e9a1a858e0a2bb8a4b186562");
	               firewall_sonicwall_match++;
            }
		}

		if (_d2727c1761e69bce90895f2e3f24f3eeab5bb859.size() > 0) {
            for(String evt : _d2727c1761e69bce90895f2e3f24f3eeab5bb859){
		           createAlert(evt, "_d2727c1761e69bce90895f2e3f24f3eeab5bb859");
	               firewall_sonicwall_match++;
            }
		}

		if (_cfeebcdea078cb4ce9602c456040fb85ba6a672c.size() > 0) {
            for(String evt : _cfeebcdea078cb4ce9602c456040fb85ba6a672c){
		           createAlert(evt, "_cfeebcdea078cb4ce9602c456040fb85ba6a672c");
	               firewall_sonicwall_match++;
            }
		}

		if (_b07720fc42e2ccdc44d37a3aafffba6ed50da46d.size() > 0) {
            for(String evt : _b07720fc42e2ccdc44d37a3aafffba6ed50da46d){
		           createAlert(evt, "_b07720fc42e2ccdc44d37a3aafffba6ed50da46d");
	               firewall_sonicwall_match++;
            }
		}

		if (_6955fa5aa1e2d5d595597c6300df5ae7e5e78b96.size() > 0) {
            for(String evt : _6955fa5aa1e2d5d595597c6300df5ae7e5e78b96){
		           createAlert(evt, "_6955fa5aa1e2d5d595597c6300df5ae7e5e78b96");
	               firewall_sonicwall_match++;
            }
		}

		if (_729e1e034a67dc4cc06033eacb45bcee73ab7a38.size() > 0) {
            for(String evt : _729e1e034a67dc4cc06033eacb45bcee73ab7a38){
		           createAlert(evt, "_729e1e034a67dc4cc06033eacb45bcee73ab7a38");
	               firewall_sonicwall_match++;
            }
		}

		if (_ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5.size() > 0) {
            for(String evt : _ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5){
		           createAlert(evt, "_ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5");
	               firewall_sonicwall_match++;
            }
		}

		if (_19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3.size() > 0) {
            for(String evt : _19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3){
		           createAlert(evt, "_19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3");
	               firewall_sonicwall_match++;
            }
		}

		if (_532071fc551da07f8c314f0cd0e7e749620e3240.size() > 0) {
            for(String evt : _532071fc551da07f8c314f0cd0e7e749620e3240){
		           createAlert(evt, "_532071fc551da07f8c314f0cd0e7e749620e3240");
	               firewall_sonicwall_match++;
            }
		}

		if (_2ab2471852138580321e2768eb86006313ddd34d.size() > 0) {
            for(String evt : _2ab2471852138580321e2768eb86006313ddd34d){
		           createAlert(evt, "_2ab2471852138580321e2768eb86006313ddd34d");
	               firewall_sonicwall_match++;
            }
		}

		if (_083d95bb2055cb63ae6e0bc7044065055ff12365.size() > 0) {
            for(String evt : _083d95bb2055cb63ae6e0bc7044065055ff12365){
		           createAlert(evt, "_083d95bb2055cb63ae6e0bc7044065055ff12365");
	               firewall_sonicwall_match++;
            }
		}

		if (_5441f73c76eb60aeaa8f896a16a991c825b8b0c5.size() > 0) {
            for(String evt : _5441f73c76eb60aeaa8f896a16a991c825b8b0c5){
		           createAlert(evt, "_5441f73c76eb60aeaa8f896a16a991c825b8b0c5");
	               firewall_sonicwall_match++;
            }
		}

		if (_c95d98b19dfc53a078269b7dd33acc21d9b0918f.size() > 0) {
            for(String evt : _c95d98b19dfc53a078269b7dd33acc21d9b0918f){
		           createAlert(evt, "_c95d98b19dfc53a078269b7dd33acc21d9b0918f");
	               firewall_sonicwall_match++;
            }
		}

        ret += "firewall_sonicwall_ins_" + firewall_sonicwall_match + ",";

        ret += "firewall_sonicwall_eps_" + firewall_sonicwall_evt + ",";
                
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


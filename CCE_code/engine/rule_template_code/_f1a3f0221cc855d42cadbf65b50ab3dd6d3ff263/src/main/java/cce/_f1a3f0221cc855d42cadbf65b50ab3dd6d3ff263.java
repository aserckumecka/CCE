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

public class _f1a3f0221cc855d42cadbf65b50ab3dd6d3ff263 implements RequestHandler<List<HashMap<String, String>>, String> {
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
        int firewall_ciscoasa_match = 0;
        int firewall_ciscoasa_evt = 0;
	ArrayList<String> _308114e3faf94ee4bf76aad5c15cae30f0663b44 = new ArrayList<String>();
	ArrayList<String> _ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4 = new ArrayList<String>();
	ArrayList<String> _bfdb043b89a2e0f548ed9e52997870c6f3c45014 = new ArrayList<String>();
	ArrayList<String> _99ac84a04fd97bf3462fbd100faaaab08a901e10 = new ArrayList<String>();
	ArrayList<String> _ef8ce7059cd069b5eab9ee65f70244199f673c7d = new ArrayList<String>();
	ArrayList<String> _3560b6ad448e359a1778d52398d309f7fb3d5909 = new ArrayList<String>();
	ArrayList<String> _798a6e631a857e96e29316fa19d52dbf4149349d = new ArrayList<String>();
	ArrayList<String> _6198846fb20ea84d49c5a6166f909a93ceabfb13 = new ArrayList<String>();
	ArrayList<String> _45a727364b94fadf587df9745dfef4145cabe3a4 = new ArrayList<String>();
	ArrayList<String> _352d656d4658cd8c1c2a0c1c96bceb201b5a50af = new ArrayList<String>();
	ArrayList<String> _f27a3669812c7a1ae3ac237e7abe60124ea481e2 = new ArrayList<String>();
	ArrayList<String> _29077866c55010fad6ac856eda6e87b27f3b9a6e = new ArrayList<String>();
	ArrayList<String> _caaaa6d375c1e198f8f014533da28887214615c0 = new ArrayList<String>();
	ArrayList<String> _80fab6c47cd1638edd0d231c87c9164d82717594 = new ArrayList<String>();
	ArrayList<String> _70da53ed24b6e35c80b0020a6694caadd2fce54e = new ArrayList<String>();
	ArrayList<String> _00a33efb0cc129f0fa7aae0284660eaee188d71d = new ArrayList<String>();
	ArrayList<String> _56aadeedaa9afa1d467a25c07bd20709551ed94c = new ArrayList<String>();
	ArrayList<String> _0bc5a165302778e76f2992c8cf320ce79bc3f38a = new ArrayList<String>();
	ArrayList<String> _a998cffe2989673eefc70ae3e28a0c1bb5b33499 = new ArrayList<String>();
	ArrayList<String> _9b92f45c8f76e00a88a2cf1dd0454c5589b3c592 = new ArrayList<String>();
	ArrayList<String> _42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c = new ArrayList<String>();
	ArrayList<String> _cde203ca62887942a7c6b9c48e06413551e96db0 = new ArrayList<String>();
        int webserver_php_match = 0;
        int webserver_php_evt = 0;
	ArrayList<String> _4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b = new ArrayList<String>();
	ArrayList<String> _e1c092360645fd9ff81a46a805c50c7894e6d54b = new ArrayList<String>();
	ArrayList<String> _1e8696f57bb750c1bdd148c0a7267afe2b281fb3 = new ArrayList<String>();
	ArrayList<String> _cb8055bb788b822ad1d40580b050169fcc60754b = new ArrayList<String>();
	ArrayList<String> _3cb7b4b5fb15930c0fc776d660058b08db1dbc1f = new ArrayList<String>();
	ArrayList<String> _27b6c41639addfbdcff9f6a513076cafb60547d0 = new ArrayList<String>();
	ArrayList<String> _c01c7aaae27989e4b674667c88198c9e80e3ce54 = new ArrayList<String>();
	ArrayList<String> _83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3 = new ArrayList<String>();
	ArrayList<String> _bc0c81e27ca7b5f7782583e0347633581718a987 = new ArrayList<String>();
	ArrayList<String> _b7a87936144684abb7fd43824e3aa787de584c68 = new ArrayList<String>();
	ArrayList<String> _9e57911ff0984b4774d029758bf8e11d64d985c8 = new ArrayList<String>();
	ArrayList<String> _7cc264d11a463521fae7de3f7d329b8ca4d1b6ba = new ArrayList<String>();
	ArrayList<String> _268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75 = new ArrayList<String>();
	ArrayList<String> _40301a843dd58b330855ec32978d93a67a317dba = new ArrayList<String>();
	ArrayList<String> _4a43b95828d82b9e010be803ec27675351693a45 = new ArrayList<String>();
	ArrayList<String> _f82520cd23c730a8af6a42f0494f12d56800e0e1 = new ArrayList<String>();
	ArrayList<String> _3e2cc6a69c2c255abaf124b8f5f415baab226c08 = new ArrayList<String>();
	ArrayList<String> _24ca0b96b57c0be035ae37a08b85d91fadb68f32 = new ArrayList<String>();
	ArrayList<String> _1e7f11fc010b53d32d57c8cad4595bcd182c41fd = new ArrayList<String>();
	ArrayList<String> _8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e = new ArrayList<String>();
	ArrayList<String> _e43d2d7fb4254f8475ec5beb7beded9953d6f949 = new ArrayList<String>();
	ArrayList<String> _c708369c931c7f1385247bca2448952a1705a3e4 = new ArrayList<String>();
	ArrayList<String> _326dc6ca1a4b857b796f4fbaaca0a741539702c1 = new ArrayList<String>();
	ArrayList<String> _ea4ac288269be3260f9ed4b5d347697e3be476cc = new ArrayList<String>();
	ArrayList<String> _853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf = new ArrayList<String>();
	ArrayList<String> _3ef39f6a40e145812ed9e15439bf4e7b3fe345ad = new ArrayList<String>();
    	
        for (HashMap<String, String> eventMap : eventBatch) {
	        String dvchost = eventMap.get("dvchost");
	        String rt = eventMap.get("rt");
        	String eventid = eventMap.get("eventid");
        	//verifCodes
		if (dvchost.equals("firewall.ciscoasa")) {
		    firewall_ciscoasa_evt++;

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost183")){
    				_308114e3faf94ee4bf76aad5c15cae30f0663b44.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost162")){
    				_ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost39")){
    				_bfdb043b89a2e0f548ed9e52997870c6f3c45014.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost218")){
    				_99ac84a04fd97bf3462fbd100faaaab08a901e10.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost222")){
    				_ef8ce7059cd069b5eab9ee65f70244199f673c7d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost181")){
    				_3560b6ad448e359a1778d52398d309f7fb3d5909.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.17.")){
    				_798a6e631a857e96e29316fa19d52dbf4149349d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.243.")){
    				_6198846fb20ea84d49c5a6166f909a93ceabfb13.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost69")){
    				_45a727364b94fadf587df9745dfef4145cabe3a4.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost224")){
    				_352d656d4658cd8c1c2a0c1c96bceb201b5a50af.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser255")){
    				_f27a3669812c7a1ae3ac237e7abe60124ea481e2.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost22")){
    				_29077866c55010fad6ac856eda6e87b27f3b9a6e.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.208.")){
    				_caaaa6d375c1e198f8f014533da28887214615c0.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser186")){
    				_80fab6c47cd1638edd0d231c87c9164d82717594.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser187")){
    				_70da53ed24b6e35c80b0020a6694caadd2fce54e.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser119")){
    				_00a33efb0cc129f0fa7aae0284660eaee188d71d.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost119")){
    				_56aadeedaa9afa1d467a25c07bd20709551ed94c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost6")){
    				_0bc5a165302778e76f2992c8cf320ce79bc3f38a.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser61")){
    				_a998cffe2989673eefc70ae3e28a0c1bb5b33499.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost199")){
    				_9b92f45c8f76e00a88a2cf1dd0454c5589b3c592.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser191")){
    				_42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.108.")){
    				_cde203ca62887942a7c6b9c48e06413551e96db0.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
		if (dvchost.equals("webserver.php")) {
		    webserver_php_evt++;

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.183.")){
    				_4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.162.")){
    				_e1c092360645fd9ff81a46a805c50c7894e6d54b.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser222")){
    				_1e8696f57bb750c1bdd148c0a7267afe2b281fb3.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser231")){
    				_cb8055bb788b822ad1d40580b050169fcc60754b.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.58.")){
    				_3cb7b4b5fb15930c0fc776d660058b08db1dbc1f.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.111.")){
    				_27b6c41639addfbdcff9f6a513076cafb60547d0.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost111")){
    				_c01c7aaae27989e4b674667c88198c9e80e3ce54.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.96.")){
    				_83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser96")){
    				_bc0c81e27ca7b5f7782583e0347633581718a987.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost96")){
    				_b7a87936144684abb7fd43824e3aa787de584c68.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser207")){
    				_9e57911ff0984b4774d029758bf8e11d64d985c8.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.11.")){
    				_7cc264d11a463521fae7de3f7d329b8ca4d1b6ba.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.149.")){
    				_268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.22.")){
    				_40301a843dd58b330855ec32978d93a67a317dba.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.186.")){
    				_4a43b95828d82b9e010be803ec27675351693a45.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost187")){
    				_f82520cd23c730a8af6a42f0494f12d56800e0e1.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.61.")){
    				_3e2cc6a69c2c255abaf124b8f5f415baab226c08.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost61")){
    				_24ca0b96b57c0be035ae37a08b85d91fadb68f32.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost201")){
    				_1e7f11fc010b53d32d57c8cad4595bcd182c41fd.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser17")){
    				_8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser68")){
    				_e43d2d7fb4254f8475ec5beb7beded9953d6f949.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("duser", "rt").equals("duser109")){
    				_c708369c931c7f1385247bca2448952a1705a3e4.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.181.")){
    				_326dc6ca1a4b857b796f4fbaaca0a741539702c1.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost230")){
    				_ea4ac288269be3260f9ed4b5d347697e3be476cc.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("src_ip", "rt").startsWith("192.168.15.")){
    				_853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

			if (eventMap.getOrDefault("dhost", "rt").equals("dhost15")){
    				_3ef39f6a40e145812ed9e15439bf4e7b3fe345ad.add("eventid="+ eventid +", "+ "dvchost="+ dvchost +", "+ "rt="+ rt);
			}

		}
        }
        //condCodes

		if (_308114e3faf94ee4bf76aad5c15cae30f0663b44.size() > 0) {
            for(String evt : _308114e3faf94ee4bf76aad5c15cae30f0663b44){
		           createAlert(evt, "_308114e3faf94ee4bf76aad5c15cae30f0663b44");
	               firewall_ciscoasa_match++;
            }
		}

		if (_ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4.size() > 0) {
            for(String evt : _ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4){
		           createAlert(evt, "_ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4");
	               firewall_ciscoasa_match++;
            }
		}

		if (_bfdb043b89a2e0f548ed9e52997870c6f3c45014.size() > 0) {
            for(String evt : _bfdb043b89a2e0f548ed9e52997870c6f3c45014){
		           createAlert(evt, "_bfdb043b89a2e0f548ed9e52997870c6f3c45014");
	               firewall_ciscoasa_match++;
            }
		}

		if (_99ac84a04fd97bf3462fbd100faaaab08a901e10.size() > 0) {
            for(String evt : _99ac84a04fd97bf3462fbd100faaaab08a901e10){
		           createAlert(evt, "_99ac84a04fd97bf3462fbd100faaaab08a901e10");
	               firewall_ciscoasa_match++;
            }
		}

		if (_ef8ce7059cd069b5eab9ee65f70244199f673c7d.size() > 0) {
            for(String evt : _ef8ce7059cd069b5eab9ee65f70244199f673c7d){
		           createAlert(evt, "_ef8ce7059cd069b5eab9ee65f70244199f673c7d");
	               firewall_ciscoasa_match++;
            }
		}

		if (_3560b6ad448e359a1778d52398d309f7fb3d5909.size() > 0) {
            for(String evt : _3560b6ad448e359a1778d52398d309f7fb3d5909){
		           createAlert(evt, "_3560b6ad448e359a1778d52398d309f7fb3d5909");
	               firewall_ciscoasa_match++;
            }
		}

		if (_798a6e631a857e96e29316fa19d52dbf4149349d.size() > 0) {
            for(String evt : _798a6e631a857e96e29316fa19d52dbf4149349d){
		           createAlert(evt, "_798a6e631a857e96e29316fa19d52dbf4149349d");
	               firewall_ciscoasa_match++;
            }
		}

		if (_6198846fb20ea84d49c5a6166f909a93ceabfb13.size() > 0) {
            for(String evt : _6198846fb20ea84d49c5a6166f909a93ceabfb13){
		           createAlert(evt, "_6198846fb20ea84d49c5a6166f909a93ceabfb13");
	               firewall_ciscoasa_match++;
            }
		}

		if (_45a727364b94fadf587df9745dfef4145cabe3a4.size() > 0) {
            for(String evt : _45a727364b94fadf587df9745dfef4145cabe3a4){
		           createAlert(evt, "_45a727364b94fadf587df9745dfef4145cabe3a4");
	               firewall_ciscoasa_match++;
            }
		}

		if (_352d656d4658cd8c1c2a0c1c96bceb201b5a50af.size() > 0) {
            for(String evt : _352d656d4658cd8c1c2a0c1c96bceb201b5a50af){
		           createAlert(evt, "_352d656d4658cd8c1c2a0c1c96bceb201b5a50af");
	               firewall_ciscoasa_match++;
            }
		}

		if (_f27a3669812c7a1ae3ac237e7abe60124ea481e2.size() > 0) {
            for(String evt : _f27a3669812c7a1ae3ac237e7abe60124ea481e2){
		           createAlert(evt, "_f27a3669812c7a1ae3ac237e7abe60124ea481e2");
	               firewall_ciscoasa_match++;
            }
		}

		if (_29077866c55010fad6ac856eda6e87b27f3b9a6e.size() > 0) {
            for(String evt : _29077866c55010fad6ac856eda6e87b27f3b9a6e){
		           createAlert(evt, "_29077866c55010fad6ac856eda6e87b27f3b9a6e");
	               firewall_ciscoasa_match++;
            }
		}

		if (_caaaa6d375c1e198f8f014533da28887214615c0.size() > 0) {
            for(String evt : _caaaa6d375c1e198f8f014533da28887214615c0){
		           createAlert(evt, "_caaaa6d375c1e198f8f014533da28887214615c0");
	               firewall_ciscoasa_match++;
            }
		}

		if (_f27a3669812c7a1ae3ac237e7abe60124ea481e2.size() > 0) {
            for(String evt : _f27a3669812c7a1ae3ac237e7abe60124ea481e2){
		           createAlert(evt, "_f27a3669812c7a1ae3ac237e7abe60124ea481e2");
	               firewall_ciscoasa_match++;
            }
		}

		if (_80fab6c47cd1638edd0d231c87c9164d82717594.size() > 0) {
            for(String evt : _80fab6c47cd1638edd0d231c87c9164d82717594){
		           createAlert(evt, "_80fab6c47cd1638edd0d231c87c9164d82717594");
	               firewall_ciscoasa_match++;
            }
		}

		if (_70da53ed24b6e35c80b0020a6694caadd2fce54e.size() > 0) {
            for(String evt : _70da53ed24b6e35c80b0020a6694caadd2fce54e){
		           createAlert(evt, "_70da53ed24b6e35c80b0020a6694caadd2fce54e");
	               firewall_ciscoasa_match++;
            }
		}

		if (_00a33efb0cc129f0fa7aae0284660eaee188d71d.size() > 0) {
            for(String evt : _00a33efb0cc129f0fa7aae0284660eaee188d71d){
		           createAlert(evt, "_00a33efb0cc129f0fa7aae0284660eaee188d71d");
	               firewall_ciscoasa_match++;
            }
		}

		if (_56aadeedaa9afa1d467a25c07bd20709551ed94c.size() > 0) {
            for(String evt : _56aadeedaa9afa1d467a25c07bd20709551ed94c){
		           createAlert(evt, "_56aadeedaa9afa1d467a25c07bd20709551ed94c");
	               firewall_ciscoasa_match++;
            }
		}

		if (_0bc5a165302778e76f2992c8cf320ce79bc3f38a.size() > 0) {
            for(String evt : _0bc5a165302778e76f2992c8cf320ce79bc3f38a){
		           createAlert(evt, "_0bc5a165302778e76f2992c8cf320ce79bc3f38a");
	               firewall_ciscoasa_match++;
            }
		}

		if (_a998cffe2989673eefc70ae3e28a0c1bb5b33499.size() > 0) {
            for(String evt : _a998cffe2989673eefc70ae3e28a0c1bb5b33499){
		           createAlert(evt, "_a998cffe2989673eefc70ae3e28a0c1bb5b33499");
	               firewall_ciscoasa_match++;
            }
		}

		if (_798a6e631a857e96e29316fa19d52dbf4149349d.size() > 0) {
            for(String evt : _798a6e631a857e96e29316fa19d52dbf4149349d){
		           createAlert(evt, "_798a6e631a857e96e29316fa19d52dbf4149349d");
	               firewall_ciscoasa_match++;
            }
		}

		if (_9b92f45c8f76e00a88a2cf1dd0454c5589b3c592.size() > 0) {
            for(String evt : _9b92f45c8f76e00a88a2cf1dd0454c5589b3c592){
		           createAlert(evt, "_9b92f45c8f76e00a88a2cf1dd0454c5589b3c592");
	               firewall_ciscoasa_match++;
            }
		}

		if (_42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c.size() > 0) {
            for(String evt : _42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c){
		           createAlert(evt, "_42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c");
	               firewall_ciscoasa_match++;
            }
		}

		if (_cde203ca62887942a7c6b9c48e06413551e96db0.size() > 0) {
            for(String evt : _cde203ca62887942a7c6b9c48e06413551e96db0){
		           createAlert(evt, "_cde203ca62887942a7c6b9c48e06413551e96db0");
	               firewall_ciscoasa_match++;
            }
		}

        ret += "firewall_ciscoasa_ins_" + firewall_ciscoasa_match + ",";

        ret += "firewall_ciscoasa_eps_" + firewall_ciscoasa_evt + ",";

		if (_4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b.size() > 0) {
            for(String evt : _4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b){
		           createAlert(evt, "_4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b");
	               webserver_php_match++;
            }
		}

		if (_e1c092360645fd9ff81a46a805c50c7894e6d54b.size() > 0) {
            for(String evt : _e1c092360645fd9ff81a46a805c50c7894e6d54b){
		           createAlert(evt, "_e1c092360645fd9ff81a46a805c50c7894e6d54b");
	               webserver_php_match++;
            }
		}

		if (_1e8696f57bb750c1bdd148c0a7267afe2b281fb3.size() > 0) {
            for(String evt : _1e8696f57bb750c1bdd148c0a7267afe2b281fb3){
		           createAlert(evt, "_1e8696f57bb750c1bdd148c0a7267afe2b281fb3");
	               webserver_php_match++;
            }
		}

		if (_cb8055bb788b822ad1d40580b050169fcc60754b.size() > 0) {
            for(String evt : _cb8055bb788b822ad1d40580b050169fcc60754b){
		           createAlert(evt, "_cb8055bb788b822ad1d40580b050169fcc60754b");
	               webserver_php_match++;
            }
		}

		if (_3cb7b4b5fb15930c0fc776d660058b08db1dbc1f.size() > 0) {
            for(String evt : _3cb7b4b5fb15930c0fc776d660058b08db1dbc1f){
		           createAlert(evt, "_3cb7b4b5fb15930c0fc776d660058b08db1dbc1f");
	               webserver_php_match++;
            }
		}

		if (_27b6c41639addfbdcff9f6a513076cafb60547d0.size() > 0) {
            for(String evt : _27b6c41639addfbdcff9f6a513076cafb60547d0){
		           createAlert(evt, "_27b6c41639addfbdcff9f6a513076cafb60547d0");
	               webserver_php_match++;
            }
		}

		if (_c01c7aaae27989e4b674667c88198c9e80e3ce54.size() > 0) {
            for(String evt : _c01c7aaae27989e4b674667c88198c9e80e3ce54){
		           createAlert(evt, "_c01c7aaae27989e4b674667c88198c9e80e3ce54");
	               webserver_php_match++;
            }
		}

		if (_83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3.size() > 0) {
            for(String evt : _83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3){
		           createAlert(evt, "_83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3");
	               webserver_php_match++;
            }
		}

		if (_bc0c81e27ca7b5f7782583e0347633581718a987.size() > 0) {
            for(String evt : _bc0c81e27ca7b5f7782583e0347633581718a987){
		           createAlert(evt, "_bc0c81e27ca7b5f7782583e0347633581718a987");
	               webserver_php_match++;
            }
		}

		if (_b7a87936144684abb7fd43824e3aa787de584c68.size() > 0) {
            for(String evt : _b7a87936144684abb7fd43824e3aa787de584c68){
		           createAlert(evt, "_b7a87936144684abb7fd43824e3aa787de584c68");
	               webserver_php_match++;
            }
		}

		if (_9e57911ff0984b4774d029758bf8e11d64d985c8.size() > 0) {
            for(String evt : _9e57911ff0984b4774d029758bf8e11d64d985c8){
		           createAlert(evt, "_9e57911ff0984b4774d029758bf8e11d64d985c8");
	               webserver_php_match++;
            }
		}

		if (_7cc264d11a463521fae7de3f7d329b8ca4d1b6ba.size() > 0) {
            for(String evt : _7cc264d11a463521fae7de3f7d329b8ca4d1b6ba){
		           createAlert(evt, "_7cc264d11a463521fae7de3f7d329b8ca4d1b6ba");
	               webserver_php_match++;
            }
		}

		if (_268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75.size() > 0) {
            for(String evt : _268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75){
		           createAlert(evt, "_268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75");
	               webserver_php_match++;
            }
		}

		if (_40301a843dd58b330855ec32978d93a67a317dba.size() > 0) {
            for(String evt : _40301a843dd58b330855ec32978d93a67a317dba){
		           createAlert(evt, "_40301a843dd58b330855ec32978d93a67a317dba");
	               webserver_php_match++;
            }
		}

		if (_4a43b95828d82b9e010be803ec27675351693a45.size() > 0) {
            for(String evt : _4a43b95828d82b9e010be803ec27675351693a45){
		           createAlert(evt, "_4a43b95828d82b9e010be803ec27675351693a45");
	               webserver_php_match++;
            }
		}

		if (_f82520cd23c730a8af6a42f0494f12d56800e0e1.size() > 0) {
            for(String evt : _f82520cd23c730a8af6a42f0494f12d56800e0e1){
		           createAlert(evt, "_f82520cd23c730a8af6a42f0494f12d56800e0e1");
	               webserver_php_match++;
            }
		}

		if (_3e2cc6a69c2c255abaf124b8f5f415baab226c08.size() > 0) {
            for(String evt : _3e2cc6a69c2c255abaf124b8f5f415baab226c08){
		           createAlert(evt, "_3e2cc6a69c2c255abaf124b8f5f415baab226c08");
	               webserver_php_match++;
            }
		}

		if (_24ca0b96b57c0be035ae37a08b85d91fadb68f32.size() > 0) {
            for(String evt : _24ca0b96b57c0be035ae37a08b85d91fadb68f32){
		           createAlert(evt, "_24ca0b96b57c0be035ae37a08b85d91fadb68f32");
	               webserver_php_match++;
            }
		}

		if (_1e7f11fc010b53d32d57c8cad4595bcd182c41fd.size() > 0) {
            for(String evt : _1e7f11fc010b53d32d57c8cad4595bcd182c41fd){
		           createAlert(evt, "_1e7f11fc010b53d32d57c8cad4595bcd182c41fd");
	               webserver_php_match++;
            }
		}

		if (_8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e.size() > 0) {
            for(String evt : _8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e){
		           createAlert(evt, "_8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e");
	               webserver_php_match++;
            }
		}

		if (_e43d2d7fb4254f8475ec5beb7beded9953d6f949.size() > 0) {
            for(String evt : _e43d2d7fb4254f8475ec5beb7beded9953d6f949){
		           createAlert(evt, "_e43d2d7fb4254f8475ec5beb7beded9953d6f949");
	               webserver_php_match++;
            }
		}

		if (_c708369c931c7f1385247bca2448952a1705a3e4.size() > 0) {
            for(String evt : _c708369c931c7f1385247bca2448952a1705a3e4){
		           createAlert(evt, "_c708369c931c7f1385247bca2448952a1705a3e4");
	               webserver_php_match++;
            }
		}

		if (_326dc6ca1a4b857b796f4fbaaca0a741539702c1.size() > 0) {
            for(String evt : _326dc6ca1a4b857b796f4fbaaca0a741539702c1){
		           createAlert(evt, "_326dc6ca1a4b857b796f4fbaaca0a741539702c1");
	               webserver_php_match++;
            }
		}

		if (_ea4ac288269be3260f9ed4b5d347697e3be476cc.size() > 0) {
            for(String evt : _ea4ac288269be3260f9ed4b5d347697e3be476cc){
		           createAlert(evt, "_ea4ac288269be3260f9ed4b5d347697e3be476cc");
	               webserver_php_match++;
            }
		}

		if (_853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf.size() > 0) {
            for(String evt : _853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf){
		           createAlert(evt, "_853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf");
	               webserver_php_match++;
            }
		}

		if (_3ef39f6a40e145812ed9e15439bf4e7b3fe345ad.size() > 0) {
            for(String evt : _3ef39f6a40e145812ed9e15439bf4e7b3fe345ad){
		           createAlert(evt, "_3ef39f6a40e145812ed9e15439bf4e7b3fe345ad");
	               webserver_php_match++;
            }
		}

        ret += "webserver_php_ins_" + webserver_php_match + ",";

        ret += "webserver_php_eps_" + webserver_php_evt + ",";
                
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


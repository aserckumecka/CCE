package cce;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

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

public class correlation implements RequestHandler<List<HashMap<String, String>>, String> {
	long lambda_ts = 0;
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
	DynamoDB dynaDB = new DynamoDB(client);
	ArrayList<String> alarms = new ArrayList<String>();
	int countAlarms = 0;

	@Override
	public String handleRequest(List<HashMap<String, String>> eventBatch, Context context) {
    		lambda_ts = System.currentTimeMillis();
    		LambdaLogger logger = context.getLogger();
    		
    		//verifVars
		ArrayList<String> _4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b = getAlert("_4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b", "1m");
		ArrayList<String> _f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8 = getAlert("_f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8", "1m");
		ArrayList<String> _308114e3faf94ee4bf76aad5c15cae30f0663b44 = getAlert("_308114e3faf94ee4bf76aad5c15cae30f0663b44", "1m");
		ArrayList<String> _e1c092360645fd9ff81a46a805c50c7894e6d54b = getAlert("_e1c092360645fd9ff81a46a805c50c7894e6d54b", "1m");
		ArrayList<String> _8855ffa89cc5af99802784b3e09f5cb87a961701 = getAlert("_8855ffa89cc5af99802784b3e09f5cb87a961701", "1m");
		ArrayList<String> _ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4 = getAlert("_ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4", "1m");
		ArrayList<String> _1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff = getAlert("_1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff", "1m");
		ArrayList<String> _cab2d644b46414f5594a29f9630bf29d7c5f8ef5 = getAlert("_cab2d644b46414f5594a29f9630bf29d7c5f8ef5", "1m");
		ArrayList<String> _fc7331ca5c15700044340a0d9413d78a21d38c53 = getAlert("_fc7331ca5c15700044340a0d9413d78a21d38c53", "1m");
		ArrayList<String> _3255b01aff5e3a409b2ceea41c2027c75bfd32b2 = getAlert("_3255b01aff5e3a409b2ceea41c2027c75bfd32b2", "1m");
		ArrayList<String> _d354aae734486401f4b42390393885ac734b0e6f = getAlert("_d354aae734486401f4b42390393885ac734b0e6f", "1m");
		ArrayList<String> _161f8800dd6f42fe6aa3b7e1987965ddfdffbae4 = getAlert("_161f8800dd6f42fe6aa3b7e1987965ddfdffbae4", "1m");
		ArrayList<String> _8358dbde4a339bda436b5cef423084bd62639688 = getAlert("_8358dbde4a339bda436b5cef423084bd62639688", "1m");
		ArrayList<String> _a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65 = getAlert("_a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65", "1m");
		ArrayList<String> _bfdb043b89a2e0f548ed9e52997870c6f3c45014 = getAlert("_bfdb043b89a2e0f548ed9e52997870c6f3c45014", "1m");
		ArrayList<String> _8e061f420df9595617803ef851d023f6e5c661a5 = getAlert("_8e061f420df9595617803ef851d023f6e5c661a5", "1m");
		ArrayList<String> _bed5c994666c80fcc3c17ec20fee3f6d1896062a = getAlert("_bed5c994666c80fcc3c17ec20fee3f6d1896062a", "1m");
		ArrayList<String> _99ac84a04fd97bf3462fbd100faaaab08a901e10 = getAlert("_99ac84a04fd97bf3462fbd100faaaab08a901e10", "1m");
		ArrayList<String> _13e745f13cc776dcf436ad73e8c4bc912deb4848 = getAlert("_13e745f13cc776dcf436ad73e8c4bc912deb4848", "1m");
		ArrayList<String> _1e8696f57bb750c1bdd148c0a7267afe2b281fb3 = getAlert("_1e8696f57bb750c1bdd148c0a7267afe2b281fb3", "1m");
		ArrayList<String> _ef8ce7059cd069b5eab9ee65f70244199f673c7d = getAlert("_ef8ce7059cd069b5eab9ee65f70244199f673c7d", "1m");
		ArrayList<String> _1bd59355994f0a7a54b49494effb8ac4f155630c = getAlert("_1bd59355994f0a7a54b49494effb8ac4f155630c", "1m");
		ArrayList<String> _f2d66fff4c109665a364295f03830189c94f3dcb = getAlert("_f2d66fff4c109665a364295f03830189c94f3dcb", "1m");
		ArrayList<String> _0786198fd896454176d4b89398662f1d39499dcb = getAlert("_0786198fd896454176d4b89398662f1d39499dcb", "1m");
		ArrayList<String> _501f6fbf66d04cb73f6dee06074226744ac53d01 = getAlert("_501f6fbf66d04cb73f6dee06074226744ac53d01", "1m");
		ArrayList<String> _1526f8cb2d2890511c6303bd8ed97b84bf707141 = getAlert("_1526f8cb2d2890511c6303bd8ed97b84bf707141", "1m");
		ArrayList<String> _3560b6ad448e359a1778d52398d309f7fb3d5909 = getAlert("_3560b6ad448e359a1778d52398d309f7fb3d5909", "1m");
		ArrayList<String> _798a6e631a857e96e29316fa19d52dbf4149349d = getAlert("_798a6e631a857e96e29316fa19d52dbf4149349d", "1m");
		ArrayList<String> _1c3411f7a94c3608c50ce2ed96156a760c914419 = getAlert("_1c3411f7a94c3608c50ce2ed96156a760c914419", "1m");
		ArrayList<String> _87bafdd10cd08b68468ced3523e25c9d0735547e = getAlert("_87bafdd10cd08b68468ced3523e25c9d0735547e", "1m");
		ArrayList<String> _6198846fb20ea84d49c5a6166f909a93ceabfb13 = getAlert("_6198846fb20ea84d49c5a6166f909a93ceabfb13", "1m");
		ArrayList<String> _afe0256f77b115c577bd6dd0e5b28a76544b1ef9 = getAlert("_afe0256f77b115c577bd6dd0e5b28a76544b1ef9", "1m");
		ArrayList<String> _3d0ae85b773eca3dbae4eed66cc6f975be42617c = getAlert("_3d0ae85b773eca3dbae4eed66cc6f975be42617c", "1m");
		ArrayList<String> _a9cd60ab36e252021954410ff19c2c2bf36458b7 = getAlert("_a9cd60ab36e252021954410ff19c2c2bf36458b7", "1m");
		ArrayList<String> _6903320f6fef6d3723340b6a2f69ea95cd32cf52 = getAlert("_6903320f6fef6d3723340b6a2f69ea95cd32cf52", "1m");
		ArrayList<String> _39d5ec83dbd5ef05dd34ab9c80b066ce882742fc = getAlert("_39d5ec83dbd5ef05dd34ab9c80b066ce882742fc", "1m");
		ArrayList<String> _51db460bec4109a8806b25413ac382e441f6f0fc = getAlert("_51db460bec4109a8806b25413ac382e441f6f0fc", "1m");
		ArrayList<String> _cb8055bb788b822ad1d40580b050169fcc60754b = getAlert("_cb8055bb788b822ad1d40580b050169fcc60754b", "1m");
		ArrayList<String> _59d9fd7f1e371142d53fc3edb44ab8727637264b = getAlert("_59d9fd7f1e371142d53fc3edb44ab8727637264b", "1m");
		ArrayList<String> _88c888001b589caba79716260013ed12a2c7bd0f = getAlert("_88c888001b589caba79716260013ed12a2c7bd0f", "1m");
		ArrayList<String> _786817da8265ff4a85c201b2088a16a5ce8f6512 = getAlert("_786817da8265ff4a85c201b2088a16a5ce8f6512", "1m");
		ArrayList<String> _e0d76b4ab67c2f46854c642eedc1ac48f09c3578 = getAlert("_e0d76b4ab67c2f46854c642eedc1ac48f09c3578", "1m");
		ArrayList<String> _a95d39176f2c4d99ade715db65c734605311a483 = getAlert("_a95d39176f2c4d99ade715db65c734605311a483", "1m");
		ArrayList<String> _779047a7a1bf76f478da117672240203a7b763cd = getAlert("_779047a7a1bf76f478da117672240203a7b763cd", "1m");
		ArrayList<String> _45a727364b94fadf587df9745dfef4145cabe3a4 = getAlert("_45a727364b94fadf587df9745dfef4145cabe3a4", "1m");
		ArrayList<String> _4ab473aa34a89a8198083b0ed8ff0db10cf69b8a = getAlert("_4ab473aa34a89a8198083b0ed8ff0db10cf69b8a", "1m");
		ArrayList<String> _1a649561d8a6ae73435872933f485f61620ac3bf = getAlert("_1a649561d8a6ae73435872933f485f61620ac3bf", "1m");
		ArrayList<String> _352d656d4658cd8c1c2a0c1c96bceb201b5a50af = getAlert("_352d656d4658cd8c1c2a0c1c96bceb201b5a50af", "1m");
		ArrayList<String> _3cb7b4b5fb15930c0fc776d660058b08db1dbc1f = getAlert("_3cb7b4b5fb15930c0fc776d660058b08db1dbc1f", "1m");
		ArrayList<String> _7317b822527ddca25b3b2bd1f81d0a7e7e664643 = getAlert("_7317b822527ddca25b3b2bd1f81d0a7e7e664643", "1m");
		ArrayList<String> _086732454ecca25fdf8c40ce141b3f483c76fed8 = getAlert("_086732454ecca25fdf8c40ce141b3f483c76fed8", "1m");
		ArrayList<String> _27b6c41639addfbdcff9f6a513076cafb60547d0 = getAlert("_27b6c41639addfbdcff9f6a513076cafb60547d0", "1m");
		ArrayList<String> _a0afd6133d8d279d6bd17ade6aba98d0bb8380c6 = getAlert("_a0afd6133d8d279d6bd17ade6aba98d0bb8380c6", "1m");
		ArrayList<String> _c01c7aaae27989e4b674667c88198c9e80e3ce54 = getAlert("_c01c7aaae27989e4b674667c88198c9e80e3ce54", "1m");
		ArrayList<String> _2834f7032e1a8bdd49aeb1ca96ca953301ff28d5 = getAlert("_2834f7032e1a8bdd49aeb1ca96ca953301ff28d5", "1m");
		ArrayList<String> _bddaa2e48a193e0a4ed625186ce2eb3caee6671d = getAlert("_bddaa2e48a193e0a4ed625186ce2eb3caee6671d", "1m");
		ArrayList<String> _79b519015241b2d44baef79a0a49b3f828658dda = getAlert("_79b519015241b2d44baef79a0a49b3f828658dda", "1m");
		ArrayList<String> _83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3 = getAlert("_83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3", "1m");
		ArrayList<String> _bc0c81e27ca7b5f7782583e0347633581718a987 = getAlert("_bc0c81e27ca7b5f7782583e0347633581718a987", "1m");
		ArrayList<String> _b7a87936144684abb7fd43824e3aa787de584c68 = getAlert("_b7a87936144684abb7fd43824e3aa787de584c68", "1m");
		ArrayList<String> _b22a522b614bc302600ba1ca1b277f641980a62c = getAlert("_b22a522b614bc302600ba1ca1b277f641980a62c", "1m");
		ArrayList<String> _9e57911ff0984b4774d029758bf8e11d64d985c8 = getAlert("_9e57911ff0984b4774d029758bf8e11d64d985c8", "1m");
		ArrayList<String> _3c29fb29b1c2b10e3ea400c996f465799d1831aa = getAlert("_3c29fb29b1c2b10e3ea400c996f465799d1831aa", "1m");
		ArrayList<String> _1bec5e965b6331438eab50198df239f8bf91101f = getAlert("_1bec5e965b6331438eab50198df239f8bf91101f", "1m");
		ArrayList<String> _f27a3669812c7a1ae3ac237e7abe60124ea481e2 = getAlert("_f27a3669812c7a1ae3ac237e7abe60124ea481e2", "1m");
		ArrayList<String> _0ba4d32386e1de02f97ea43c8c63ba90671218e6 = getAlert("_0ba4d32386e1de02f97ea43c8c63ba90671218e6", "1m");
		ArrayList<String> _2d3645438bff6890232cab9c0c4dc754d5bfb7c4 = getAlert("_2d3645438bff6890232cab9c0c4dc754d5bfb7c4", "1m");
		ArrayList<String> _0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f = getAlert("_0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f", "1m");
		ArrayList<String> _a3fcbac1d4a88af67c3f28f2abb216b2929cae41 = getAlert("_a3fcbac1d4a88af67c3f28f2abb216b2929cae41", "1m");
		ArrayList<String> _7cc264d11a463521fae7de3f7d329b8ca4d1b6ba = getAlert("_7cc264d11a463521fae7de3f7d329b8ca4d1b6ba", "1m");
		ArrayList<String> _8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726 = getAlert("_8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726", "1m");
		ArrayList<String> _2a541f25c3bd5597e9a1a858e0a2bb8a4b186562 = getAlert("_2a541f25c3bd5597e9a1a858e0a2bb8a4b186562", "1m");
		ArrayList<String> _268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75 = getAlert("_268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75", "1m");
		ArrayList<String> _d2727c1761e69bce90895f2e3f24f3eeab5bb859 = getAlert("_d2727c1761e69bce90895f2e3f24f3eeab5bb859", "1m");
		ArrayList<String> _c3882704403c2c15765bd601f7a048aaff404091 = getAlert("_c3882704403c2c15765bd601f7a048aaff404091", "1m");
		ArrayList<String> _40301a843dd58b330855ec32978d93a67a317dba = getAlert("_40301a843dd58b330855ec32978d93a67a317dba", "1m");
		ArrayList<String> _8f3584071bbbe2f6cd8a53746bbca1fd3e462606 = getAlert("_8f3584071bbbe2f6cd8a53746bbca1fd3e462606", "1m");
		ArrayList<String> _29077866c55010fad6ac856eda6e87b27f3b9a6e = getAlert("_29077866c55010fad6ac856eda6e87b27f3b9a6e", "1m");
		ArrayList<String> _caaaa6d375c1e198f8f014533da28887214615c0 = getAlert("_caaaa6d375c1e198f8f014533da28887214615c0", "1m");
		ArrayList<String> _ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c = getAlert("_ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c", "1m");
		ArrayList<String> _9d95f5f52322eca9116657c752589d1598ea0f39 = getAlert("_9d95f5f52322eca9116657c752589d1598ea0f39", "1m");
		ArrayList<String> _1543363c34e0b29094f7345688f40c7963d14e93 = getAlert("_1543363c34e0b29094f7345688f40c7963d14e93", "1m");
		ArrayList<String> _43e291d7f935d7ed0f19203a3fda31b8280b1915 = getAlert("_43e291d7f935d7ed0f19203a3fda31b8280b1915", "1m");
		ArrayList<String> _9843e22e87a3e2e033823c108365611fd0f0f251 = getAlert("_9843e22e87a3e2e033823c108365611fd0f0f251", "1m");
		ArrayList<String> _af3c197b3295234faf3df6c896d0fcf5e4d65c56 = getAlert("_af3c197b3295234faf3df6c896d0fcf5e4d65c56", "1m");
		ArrayList<String> _f122ed273a4bcad4a0c658940b4c7654f279c45f = getAlert("_f122ed273a4bcad4a0c658940b4c7654f279c45f", "1m");
		ArrayList<String> _4a43b95828d82b9e010be803ec27675351693a45 = getAlert("_4a43b95828d82b9e010be803ec27675351693a45", "1m");
		ArrayList<String> _80fab6c47cd1638edd0d231c87c9164d82717594 = getAlert("_80fab6c47cd1638edd0d231c87c9164d82717594", "1m");
		ArrayList<String> _5726646293b17a8e7685acca58be36f4c5a63169 = getAlert("_5726646293b17a8e7685acca58be36f4c5a63169", "1m");
		ArrayList<String> _fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505 = getAlert("_fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505", "1m");
		ArrayList<String> _70da53ed24b6e35c80b0020a6694caadd2fce54e = getAlert("_70da53ed24b6e35c80b0020a6694caadd2fce54e", "1m");
		ArrayList<String> _f82520cd23c730a8af6a42f0494f12d56800e0e1 = getAlert("_f82520cd23c730a8af6a42f0494f12d56800e0e1", "1m");
		ArrayList<String> _2246284dd1a6b258b27666358875cfcde34ec1ba = getAlert("_2246284dd1a6b258b27666358875cfcde34ec1ba", "1m");
		ArrayList<String> _00a33efb0cc129f0fa7aae0284660eaee188d71d = getAlert("_00a33efb0cc129f0fa7aae0284660eaee188d71d", "1m");
		ArrayList<String> _56aadeedaa9afa1d467a25c07bd20709551ed94c = getAlert("_56aadeedaa9afa1d467a25c07bd20709551ed94c", "1m");
		ArrayList<String> _cfeebcdea078cb4ce9602c456040fb85ba6a672c = getAlert("_cfeebcdea078cb4ce9602c456040fb85ba6a672c", "1m");
		ArrayList<String> _affcbe9bf7432434433f165b4385a9b920f090b3 = getAlert("_affcbe9bf7432434433f165b4385a9b920f090b3", "1m");
		ArrayList<String> _0bc5a165302778e76f2992c8cf320ce79bc3f38a = getAlert("_0bc5a165302778e76f2992c8cf320ce79bc3f38a", "1m");
		ArrayList<String> _773b1da9a68e502a99f9ea843689a89902aa5fc7 = getAlert("_773b1da9a68e502a99f9ea843689a89902aa5fc7", "1m");
		ArrayList<String> _e4fa7e6187c45103d71127bf9c37e7f57a77f40c = getAlert("_e4fa7e6187c45103d71127bf9c37e7f57a77f40c", "1m");
		ArrayList<String> _ff5295a080360ac57b6ab26b62317ceb4a75145a = getAlert("_ff5295a080360ac57b6ab26b62317ceb4a75145a", "1m");
		ArrayList<String> _3e2cc6a69c2c255abaf124b8f5f415baab226c08 = getAlert("_3e2cc6a69c2c255abaf124b8f5f415baab226c08", "1m");
		ArrayList<String> _a998cffe2989673eefc70ae3e28a0c1bb5b33499 = getAlert("_a998cffe2989673eefc70ae3e28a0c1bb5b33499", "1m");
		ArrayList<String> _24ca0b96b57c0be035ae37a08b85d91fadb68f32 = getAlert("_24ca0b96b57c0be035ae37a08b85d91fadb68f32", "1m");
		ArrayList<String> _c5220a05e1b8d33bc5fe13979bff72bce2f79bf6 = getAlert("_c5220a05e1b8d33bc5fe13979bff72bce2f79bf6", "1m");
		ArrayList<String> _9ae0bef74f955a517cd6c820e3732c528f3a2457 = getAlert("_9ae0bef74f955a517cd6c820e3732c528f3a2457", "1m");
		ArrayList<String> _1e7f11fc010b53d32d57c8cad4595bcd182c41fd = getAlert("_1e7f11fc010b53d32d57c8cad4595bcd182c41fd", "1m");
		ArrayList<String> _8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e = getAlert("_8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e", "1m");
		ArrayList<String> _b07720fc42e2ccdc44d37a3aafffba6ed50da46d = getAlert("_b07720fc42e2ccdc44d37a3aafffba6ed50da46d", "1m");
		ArrayList<String> _6955fa5aa1e2d5d595597c6300df5ae7e5e78b96 = getAlert("_6955fa5aa1e2d5d595597c6300df5ae7e5e78b96", "1m");
		ArrayList<String> _729e1e034a67dc4cc06033eacb45bcee73ab7a38 = getAlert("_729e1e034a67dc4cc06033eacb45bcee73ab7a38", "1m");
		ArrayList<String> _9b92f45c8f76e00a88a2cf1dd0454c5589b3c592 = getAlert("_9b92f45c8f76e00a88a2cf1dd0454c5589b3c592", "1m");
		ArrayList<String> _869b92e50d212a883577d747676e03c197527630 = getAlert("_869b92e50d212a883577d747676e03c197527630", "1m");
		ArrayList<String> _42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c = getAlert("_42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c", "1m");
		ArrayList<String> _a0f744c232cc5faf1c8304e5deb90423da3c09fa = getAlert("_a0f744c232cc5faf1c8304e5deb90423da3c09fa", "1m");
		ArrayList<String> _4abbfce16d018ffee88a2fb362482d42fe60a2a4 = getAlert("_4abbfce16d018ffee88a2fb362482d42fe60a2a4", "1m");
		ArrayList<String> _e43d2d7fb4254f8475ec5beb7beded9953d6f949 = getAlert("_e43d2d7fb4254f8475ec5beb7beded9953d6f949", "1m");
		ArrayList<String> _ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5 = getAlert("_ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5", "1m");
		ArrayList<String> _400ea6fef3e51b365f858cdfe024c89a704df2b2 = getAlert("_400ea6fef3e51b365f858cdfe024c89a704df2b2", "1m");
		ArrayList<String> _0f54473c7180eeede35ee1ecde143d543f45b041 = getAlert("_0f54473c7180eeede35ee1ecde143d543f45b041", "1m");
		ArrayList<String> _33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c = getAlert("_33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c", "1m");
		ArrayList<String> _19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3 = getAlert("_19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3", "1m");
		ArrayList<String> _0bddf658d6d6cdc030f57b934ae48ca380c54e9a = getAlert("_0bddf658d6d6cdc030f57b934ae48ca380c54e9a", "1m");
		ArrayList<String> _db2bd5c92ce2eb63f14cb78340626d37c6669974 = getAlert("_db2bd5c92ce2eb63f14cb78340626d37c6669974", "1m");
		ArrayList<String> _2fd282a998c1cea0117224bd7022ac651cddb2a0 = getAlert("_2fd282a998c1cea0117224bd7022ac651cddb2a0", "1m");
		ArrayList<String> _c708369c931c7f1385247bca2448952a1705a3e4 = getAlert("_c708369c931c7f1385247bca2448952a1705a3e4", "1m");
		ArrayList<String> _6ae545c829e7aa07e363fcf3f089555c3f27417e = getAlert("_6ae545c829e7aa07e363fcf3f089555c3f27417e", "1m");
		ArrayList<String> _532071fc551da07f8c314f0cd0e7e749620e3240 = getAlert("_532071fc551da07f8c314f0cd0e7e749620e3240", "1m");
		ArrayList<String> _398515f6c6d39388a88d617e8a8701e6f65cadb6 = getAlert("_398515f6c6d39388a88d617e8a8701e6f65cadb6", "1m");
		ArrayList<String> _ee01889a1db83bde384147426bf71b820489dc91 = getAlert("_ee01889a1db83bde384147426bf71b820489dc91", "1m");
		ArrayList<String> _cde203ca62887942a7c6b9c48e06413551e96db0 = getAlert("_cde203ca62887942a7c6b9c48e06413551e96db0", "1m");
		ArrayList<String> _07e5e9e8ecda5a374553d9d6d8825d2852b01055 = getAlert("_07e5e9e8ecda5a374553d9d6d8825d2852b01055", "1m");
		ArrayList<String> _9ed44ed82c793239a8d138832d4079f6e1ab204d = getAlert("_9ed44ed82c793239a8d138832d4079f6e1ab204d", "1m");
		ArrayList<String> _326dc6ca1a4b857b796f4fbaaca0a741539702c1 = getAlert("_326dc6ca1a4b857b796f4fbaaca0a741539702c1", "1m");
		ArrayList<String> _2ab2471852138580321e2768eb86006313ddd34d = getAlert("_2ab2471852138580321e2768eb86006313ddd34d", "1m");
		ArrayList<String> _8bcde9c575d4a4d7b20df07e47395d398ace53d3 = getAlert("_8bcde9c575d4a4d7b20df07e47395d398ace53d3", "1m");
		ArrayList<String> _157e5c94c2a5d389ad2d917e45325456565d01a3 = getAlert("_157e5c94c2a5d389ad2d917e45325456565d01a3", "1m");
		ArrayList<String> _083d95bb2055cb63ae6e0bc7044065055ff12365 = getAlert("_083d95bb2055cb63ae6e0bc7044065055ff12365", "1m");
		ArrayList<String> _ea4ac288269be3260f9ed4b5d347697e3be476cc = getAlert("_ea4ac288269be3260f9ed4b5d347697e3be476cc", "1m");
		ArrayList<String> _b133ab180b1fb60959d04719654385e01e077a4d = getAlert("_b133ab180b1fb60959d04719654385e01e077a4d", "1m");
		ArrayList<String> _de4503a22877f834c4220bbae5edbb204de94b5e = getAlert("_de4503a22877f834c4220bbae5edbb204de94b5e", "1m");
		ArrayList<String> _5441f73c76eb60aeaa8f896a16a991c825b8b0c5 = getAlert("_5441f73c76eb60aeaa8f896a16a991c825b8b0c5", "1m");
		ArrayList<String> _853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf = getAlert("_853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf", "1m");
		ArrayList<String> _f0e853cdbba7fcca08a85c084450255f02d0b03b = getAlert("_f0e853cdbba7fcca08a85c084450255f02d0b03b", "1m");
		ArrayList<String> _3ef39f6a40e145812ed9e15439bf4e7b3fe345ad = getAlert("_3ef39f6a40e145812ed9e15439bf4e7b3fe345ad", "1m");
		ArrayList<String> _c95d98b19dfc53a078269b7dd33acc21d9b0918f = getAlert("_c95d98b19dfc53a078269b7dd33acc21d9b0918f", "1m");
		ArrayList<String> _3b42753262a535cd129059572fdc9bffbfb3eb5d = getAlert("_3b42753262a535cd129059572fdc9bffbfb3eb5d", "1m");
		ArrayList<String> _a58273dd3c10b0da0e07d5e354f44ea02446a4d5 = getAlert("_a58273dd3c10b0da0e07d5e354f44ea02446a4d5", "1m");

		//condCodes

		if (_4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b.size() > 0 && _f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8.size() > 0 && _308114e3faf94ee4bf76aad5c15cae30f0663b44.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_4b518c4a8a0f3ad40f16c96ed6c8d99ecd02441b);
    			matches.addAll(_f3a649e6ce1c294ddb7d4cfc3dd250c4b53119a8);
    			matches.addAll(_308114e3faf94ee4bf76aad5c15cae30f0663b44);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x5";
    			String ruleInfo = "{title:Correlation rule test number 5}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_e1c092360645fd9ff81a46a805c50c7894e6d54b.size() > 0 && _8855ffa89cc5af99802784b3e09f5cb87a961701.size() > 0 && _ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_e1c092360645fd9ff81a46a805c50c7894e6d54b);
    			matches.addAll(_8855ffa89cc5af99802784b3e09f5cb87a961701);
    			matches.addAll(_ad9fd1a1d13fe33ddc54df17ada2f9f7140d06a4);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x10";
    			String ruleInfo = "{title:Correlation rule test number 10}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff.size() > 0 && _cab2d644b46414f5594a29f9630bf29d7c5f8ef5.size() > 0 && _fc7331ca5c15700044340a0d9413d78a21d38c53.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_1cff93930caa65d0acd6f2a37cd08b8ae04cc6ff);
    			matches.addAll(_cab2d644b46414f5594a29f9630bf29d7c5f8ef5);
    			matches.addAll(_fc7331ca5c15700044340a0d9413d78a21d38c53);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x7";
    			String ruleInfo = "{title:Correlation rule test number 7}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_3255b01aff5e3a409b2ceea41c2027c75bfd32b2.size() > 0 && _d354aae734486401f4b42390393885ac734b0e6f.size() > 0 && _161f8800dd6f42fe6aa3b7e1987965ddfdffbae4.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_3255b01aff5e3a409b2ceea41c2027c75bfd32b2);
    			matches.addAll(_d354aae734486401f4b42390393885ac734b0e6f);
    			matches.addAll(_161f8800dd6f42fe6aa3b7e1987965ddfdffbae4);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x14";
    			String ruleInfo = "{title:Correlation rule test number 14}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_8358dbde4a339bda436b5cef423084bd62639688.size() > 0 && _a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65.size() > 0 && _bfdb043b89a2e0f548ed9e52997870c6f3c45014.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_8358dbde4a339bda436b5cef423084bd62639688);
    			matches.addAll(_a4e6e1098c3e6f0a49ccf4f33cccbac31e4fda65);
    			matches.addAll(_bfdb043b89a2e0f548ed9e52997870c6f3c45014);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x49";
    			String ruleInfo = "{title:Correlation rule test number 49}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_8e061f420df9595617803ef851d023f6e5c661a5.size() > 0 && _bed5c994666c80fcc3c17ec20fee3f6d1896062a.size() > 0 && _99ac84a04fd97bf3462fbd100faaaab08a901e10.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_8e061f420df9595617803ef851d023f6e5c661a5);
    			matches.addAll(_bed5c994666c80fcc3c17ec20fee3f6d1896062a);
    			matches.addAll(_99ac84a04fd97bf3462fbd100faaaab08a901e10);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x44";
    			String ruleInfo = "{title:Correlation rule test number 44}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_13e745f13cc776dcf436ad73e8c4bc912deb4848.size() > 0 && _1e8696f57bb750c1bdd148c0a7267afe2b281fb3.size() > 0 && _ef8ce7059cd069b5eab9ee65f70244199f673c7d.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_13e745f13cc776dcf436ad73e8c4bc912deb4848);
    			matches.addAll(_1e8696f57bb750c1bdd148c0a7267afe2b281fb3);
    			matches.addAll(_ef8ce7059cd069b5eab9ee65f70244199f673c7d);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x28";
    			String ruleInfo = "{title:Correlation rule test number 28}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_1bd59355994f0a7a54b49494effb8ac4f155630c.size() > 0 && _f2d66fff4c109665a364295f03830189c94f3dcb.size() > 0 && _0786198fd896454176d4b89398662f1d39499dcb.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_1bd59355994f0a7a54b49494effb8ac4f155630c);
    			matches.addAll(_f2d66fff4c109665a364295f03830189c94f3dcb);
    			matches.addAll(_0786198fd896454176d4b89398662f1d39499dcb);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x18";
    			String ruleInfo = "{title:Correlation rule test number 18}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_501f6fbf66d04cb73f6dee06074226744ac53d01.size() > 0 && _1526f8cb2d2890511c6303bd8ed97b84bf707141.size() > 0 && _3560b6ad448e359a1778d52398d309f7fb3d5909.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_501f6fbf66d04cb73f6dee06074226744ac53d01);
    			matches.addAll(_1526f8cb2d2890511c6303bd8ed97b84bf707141);
    			matches.addAll(_3560b6ad448e359a1778d52398d309f7fb3d5909);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x15";
    			String ruleInfo = "{title:Correlation rule test number 15}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_798a6e631a857e96e29316fa19d52dbf4149349d.size() > 0 && _1c3411f7a94c3608c50ce2ed96156a760c914419.size() > 0 && _87bafdd10cd08b68468ced3523e25c9d0735547e.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_798a6e631a857e96e29316fa19d52dbf4149349d);
    			matches.addAll(_1c3411f7a94c3608c50ce2ed96156a760c914419);
    			matches.addAll(_87bafdd10cd08b68468ced3523e25c9d0735547e);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x9";
    			String ruleInfo = "{title:Correlation rule test number 9}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_6198846fb20ea84d49c5a6166f909a93ceabfb13.size() > 0 && _afe0256f77b115c577bd6dd0e5b28a76544b1ef9.size() > 0 && _3d0ae85b773eca3dbae4eed66cc6f975be42617c.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_6198846fb20ea84d49c5a6166f909a93ceabfb13);
    			matches.addAll(_afe0256f77b115c577bd6dd0e5b28a76544b1ef9);
    			matches.addAll(_3d0ae85b773eca3dbae4eed66cc6f975be42617c);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x45";
    			String ruleInfo = "{title:Correlation rule test number 45}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_a9cd60ab36e252021954410ff19c2c2bf36458b7.size() > 0 && _6903320f6fef6d3723340b6a2f69ea95cd32cf52.size() > 0 && _39d5ec83dbd5ef05dd34ab9c80b066ce882742fc.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_a9cd60ab36e252021954410ff19c2c2bf36458b7);
    			matches.addAll(_6903320f6fef6d3723340b6a2f69ea95cd32cf52);
    			matches.addAll(_39d5ec83dbd5ef05dd34ab9c80b066ce882742fc);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x32";
    			String ruleInfo = "{title:Correlation rule test number 32}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_51db460bec4109a8806b25413ac382e441f6f0fc.size() > 0 && _cb8055bb788b822ad1d40580b050169fcc60754b.size() > 0 && _59d9fd7f1e371142d53fc3edb44ab8727637264b.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_51db460bec4109a8806b25413ac382e441f6f0fc);
    			matches.addAll(_cb8055bb788b822ad1d40580b050169fcc60754b);
    			matches.addAll(_59d9fd7f1e371142d53fc3edb44ab8727637264b);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x42";
    			String ruleInfo = "{title:Correlation rule test number 42}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_88c888001b589caba79716260013ed12a2c7bd0f.size() > 0 && _786817da8265ff4a85c201b2088a16a5ce8f6512.size() > 0 && _e0d76b4ab67c2f46854c642eedc1ac48f09c3578.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_88c888001b589caba79716260013ed12a2c7bd0f);
    			matches.addAll(_786817da8265ff4a85c201b2088a16a5ce8f6512);
    			matches.addAll(_e0d76b4ab67c2f46854c642eedc1ac48f09c3578);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x48";
    			String ruleInfo = "{title:Correlation rule test number 48}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_a95d39176f2c4d99ade715db65c734605311a483.size() > 0 && _779047a7a1bf76f478da117672240203a7b763cd.size() > 0 && _45a727364b94fadf587df9745dfef4145cabe3a4.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_a95d39176f2c4d99ade715db65c734605311a483);
    			matches.addAll(_779047a7a1bf76f478da117672240203a7b763cd);
    			matches.addAll(_45a727364b94fadf587df9745dfef4145cabe3a4);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x47";
    			String ruleInfo = "{title:Correlation rule test number 47}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_4ab473aa34a89a8198083b0ed8ff0db10cf69b8a.size() > 0 && _1a649561d8a6ae73435872933f485f61620ac3bf.size() > 0 && _352d656d4658cd8c1c2a0c1c96bceb201b5a50af.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_4ab473aa34a89a8198083b0ed8ff0db10cf69b8a);
    			matches.addAll(_1a649561d8a6ae73435872933f485f61620ac3bf);
    			matches.addAll(_352d656d4658cd8c1c2a0c1c96bceb201b5a50af);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x38";
    			String ruleInfo = "{title:Correlation rule test number 38}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_3cb7b4b5fb15930c0fc776d660058b08db1dbc1f.size() > 0 && _7317b822527ddca25b3b2bd1f81d0a7e7e664643.size() > 0 && _086732454ecca25fdf8c40ce141b3f483c76fed8.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_3cb7b4b5fb15930c0fc776d660058b08db1dbc1f);
    			matches.addAll(_7317b822527ddca25b3b2bd1f81d0a7e7e664643);
    			matches.addAll(_086732454ecca25fdf8c40ce141b3f483c76fed8);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x37";
    			String ruleInfo = "{title:Correlation rule test number 37}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_27b6c41639addfbdcff9f6a513076cafb60547d0.size() > 0 && _a0afd6133d8d279d6bd17ade6aba98d0bb8380c6.size() > 0 && _c01c7aaae27989e4b674667c88198c9e80e3ce54.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_27b6c41639addfbdcff9f6a513076cafb60547d0);
    			matches.addAll(_a0afd6133d8d279d6bd17ade6aba98d0bb8380c6);
    			matches.addAll(_c01c7aaae27989e4b674667c88198c9e80e3ce54);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x27";
    			String ruleInfo = "{title:Correlation rule test number 27}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_2834f7032e1a8bdd49aeb1ca96ca953301ff28d5.size() > 0 && _bddaa2e48a193e0a4ed625186ce2eb3caee6671d.size() > 0 && _79b519015241b2d44baef79a0a49b3f828658dda.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_2834f7032e1a8bdd49aeb1ca96ca953301ff28d5);
    			matches.addAll(_bddaa2e48a193e0a4ed625186ce2eb3caee6671d);
    			matches.addAll(_79b519015241b2d44baef79a0a49b3f828658dda);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x36";
    			String ruleInfo = "{title:Correlation rule test number 36}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3.size() > 0 && _bc0c81e27ca7b5f7782583e0347633581718a987.size() > 0 && _b7a87936144684abb7fd43824e3aa787de584c68.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_83bbe7e2ee904ca2d985b2c62c81acc6e69b60d3);
    			matches.addAll(_bc0c81e27ca7b5f7782583e0347633581718a987);
    			matches.addAll(_b7a87936144684abb7fd43824e3aa787de584c68);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x13";
    			String ruleInfo = "{title:Correlation rule test number 13}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_b22a522b614bc302600ba1ca1b277f641980a62c.size() > 0 && _9e57911ff0984b4774d029758bf8e11d64d985c8.size() > 0 && _3c29fb29b1c2b10e3ea400c996f465799d1831aa.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_b22a522b614bc302600ba1ca1b277f641980a62c);
    			matches.addAll(_9e57911ff0984b4774d029758bf8e11d64d985c8);
    			matches.addAll(_3c29fb29b1c2b10e3ea400c996f465799d1831aa);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x16";
    			String ruleInfo = "{title:Correlation rule test number 16}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_1bec5e965b6331438eab50198df239f8bf91101f.size() > 0 && _f27a3669812c7a1ae3ac237e7abe60124ea481e2.size() > 0 && _0ba4d32386e1de02f97ea43c8c63ba90671218e6.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_1bec5e965b6331438eab50198df239f8bf91101f);
    			matches.addAll(_f27a3669812c7a1ae3ac237e7abe60124ea481e2);
    			matches.addAll(_0ba4d32386e1de02f97ea43c8c63ba90671218e6);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x4";
    			String ruleInfo = "{title:Correlation rule test number 4}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_2d3645438bff6890232cab9c0c4dc754d5bfb7c4.size() > 0 && _0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f.size() > 0 && _a3fcbac1d4a88af67c3f28f2abb216b2929cae41.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_2d3645438bff6890232cab9c0c4dc754d5bfb7c4);
    			matches.addAll(_0c0baf5bc0a340a8d070b86a63a16e9d58c68b9f);
    			matches.addAll(_a3fcbac1d4a88af67c3f28f2abb216b2929cae41);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x1";
    			String ruleInfo = "{title:Correlation rule test number 1}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_7cc264d11a463521fae7de3f7d329b8ca4d1b6ba.size() > 0 && _8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726.size() > 0 && _2a541f25c3bd5597e9a1a858e0a2bb8a4b186562.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_7cc264d11a463521fae7de3f7d329b8ca4d1b6ba);
    			matches.addAll(_8413c473a7c12a0c3b3f8c1ceafb7935f8f5b726);
    			matches.addAll(_2a541f25c3bd5597e9a1a858e0a2bb8a4b186562);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x12";
    			String ruleInfo = "{title:Correlation rule test number 12}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75.size() > 0 && _d2727c1761e69bce90895f2e3f24f3eeab5bb859.size() > 0 && _c3882704403c2c15765bd601f7a048aaff404091.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_268dc6e4a2ab66f7c6699025f2aeb8e268f8ae75);
    			matches.addAll(_d2727c1761e69bce90895f2e3f24f3eeab5bb859);
    			matches.addAll(_c3882704403c2c15765bd601f7a048aaff404091);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x20";
    			String ruleInfo = "{title:Correlation rule test number 20}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_40301a843dd58b330855ec32978d93a67a317dba.size() > 0 && _8f3584071bbbe2f6cd8a53746bbca1fd3e462606.size() > 0 && _29077866c55010fad6ac856eda6e87b27f3b9a6e.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_40301a843dd58b330855ec32978d93a67a317dba);
    			matches.addAll(_8f3584071bbbe2f6cd8a53746bbca1fd3e462606);
    			matches.addAll(_29077866c55010fad6ac856eda6e87b27f3b9a6e);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x31";
    			String ruleInfo = "{title:Correlation rule test number 31}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_caaaa6d375c1e198f8f014533da28887214615c0.size() > 0 && _ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c.size() > 0 && _9d95f5f52322eca9116657c752589d1598ea0f39.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_caaaa6d375c1e198f8f014533da28887214615c0);
    			matches.addAll(_ed8d3c36bcbe2dbb858ea609a0fb314e833a4d1c);
    			matches.addAll(_9d95f5f52322eca9116657c752589d1598ea0f39);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x33";
    			String ruleInfo = "{title:Correlation rule test number 33}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_1543363c34e0b29094f7345688f40c7963d14e93.size() > 0 && _43e291d7f935d7ed0f19203a3fda31b8280b1915.size() > 0 && _9843e22e87a3e2e033823c108365611fd0f0f251.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_1543363c34e0b29094f7345688f40c7963d14e93);
    			matches.addAll(_43e291d7f935d7ed0f19203a3fda31b8280b1915);
    			matches.addAll(_9843e22e87a3e2e033823c108365611fd0f0f251);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x46";
    			String ruleInfo = "{title:Correlation rule test number 46}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_af3c197b3295234faf3df6c896d0fcf5e4d65c56.size() > 0 && _f27a3669812c7a1ae3ac237e7abe60124ea481e2.size() > 0 && _f122ed273a4bcad4a0c658940b4c7654f279c45f.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_af3c197b3295234faf3df6c896d0fcf5e4d65c56);
    			matches.addAll(_f27a3669812c7a1ae3ac237e7abe60124ea481e2);
    			matches.addAll(_f122ed273a4bcad4a0c658940b4c7654f279c45f);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x35";
    			String ruleInfo = "{title:Correlation rule test number 35}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_4a43b95828d82b9e010be803ec27675351693a45.size() > 0 && _80fab6c47cd1638edd0d231c87c9164d82717594.size() > 0 && _5726646293b17a8e7685acca58be36f4c5a63169.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_4a43b95828d82b9e010be803ec27675351693a45);
    			matches.addAll(_80fab6c47cd1638edd0d231c87c9164d82717594);
    			matches.addAll(_5726646293b17a8e7685acca58be36f4c5a63169);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x19";
    			String ruleInfo = "{title:Correlation rule test number 19}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505.size() > 0 && _70da53ed24b6e35c80b0020a6694caadd2fce54e.size() > 0 && _f82520cd23c730a8af6a42f0494f12d56800e0e1.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_fad0c3d8f6d5e0cd7bd0f63635a6f2d5a7108505);
    			matches.addAll(_70da53ed24b6e35c80b0020a6694caadd2fce54e);
    			matches.addAll(_f82520cd23c730a8af6a42f0494f12d56800e0e1);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x40";
    			String ruleInfo = "{title:Correlation rule test number 40}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_2246284dd1a6b258b27666358875cfcde34ec1ba.size() > 0 && _00a33efb0cc129f0fa7aae0284660eaee188d71d.size() > 0 && _56aadeedaa9afa1d467a25c07bd20709551ed94c.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_2246284dd1a6b258b27666358875cfcde34ec1ba);
    			matches.addAll(_00a33efb0cc129f0fa7aae0284660eaee188d71d);
    			matches.addAll(_56aadeedaa9afa1d467a25c07bd20709551ed94c);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x29";
    			String ruleInfo = "{title:Correlation rule test number 29}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_cfeebcdea078cb4ce9602c456040fb85ba6a672c.size() > 0 && _affcbe9bf7432434433f165b4385a9b920f090b3.size() > 0 && _0bc5a165302778e76f2992c8cf320ce79bc3f38a.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_cfeebcdea078cb4ce9602c456040fb85ba6a672c);
    			matches.addAll(_affcbe9bf7432434433f165b4385a9b920f090b3);
    			matches.addAll(_0bc5a165302778e76f2992c8cf320ce79bc3f38a);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x50";
    			String ruleInfo = "{title:Correlation rule test number 50}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_773b1da9a68e502a99f9ea843689a89902aa5fc7.size() > 0 && _e4fa7e6187c45103d71127bf9c37e7f57a77f40c.size() > 0 && _ff5295a080360ac57b6ab26b62317ceb4a75145a.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_773b1da9a68e502a99f9ea843689a89902aa5fc7);
    			matches.addAll(_e4fa7e6187c45103d71127bf9c37e7f57a77f40c);
    			matches.addAll(_ff5295a080360ac57b6ab26b62317ceb4a75145a);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x41";
    			String ruleInfo = "{title:Correlation rule test number 41}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_3e2cc6a69c2c255abaf124b8f5f415baab226c08.size() > 0 && _a998cffe2989673eefc70ae3e28a0c1bb5b33499.size() > 0 && _24ca0b96b57c0be035ae37a08b85d91fadb68f32.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_3e2cc6a69c2c255abaf124b8f5f415baab226c08);
    			matches.addAll(_a998cffe2989673eefc70ae3e28a0c1bb5b33499);
    			matches.addAll(_24ca0b96b57c0be035ae37a08b85d91fadb68f32);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x23";
    			String ruleInfo = "{title:Correlation rule test number 23}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_c5220a05e1b8d33bc5fe13979bff72bce2f79bf6.size() > 0 && _9ae0bef74f955a517cd6c820e3732c528f3a2457.size() > 0 && _1e7f11fc010b53d32d57c8cad4595bcd182c41fd.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_c5220a05e1b8d33bc5fe13979bff72bce2f79bf6);
    			matches.addAll(_9ae0bef74f955a517cd6c820e3732c528f3a2457);
    			matches.addAll(_1e7f11fc010b53d32d57c8cad4595bcd182c41fd);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x25";
    			String ruleInfo = "{title:Correlation rule test number 25}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_798a6e631a857e96e29316fa19d52dbf4149349d.size() > 0 && _8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e.size() > 0 && _b07720fc42e2ccdc44d37a3aafffba6ed50da46d.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_798a6e631a857e96e29316fa19d52dbf4149349d);
    			matches.addAll(_8fe35f7a88b4ee03ea6c90b4bad9ce571a4cbb8e);
    			matches.addAll(_b07720fc42e2ccdc44d37a3aafffba6ed50da46d);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x6";
    			String ruleInfo = "{title:Correlation rule test number 6}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_6955fa5aa1e2d5d595597c6300df5ae7e5e78b96.size() > 0 && _729e1e034a67dc4cc06033eacb45bcee73ab7a38.size() > 0 && _9b92f45c8f76e00a88a2cf1dd0454c5589b3c592.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_6955fa5aa1e2d5d595597c6300df5ae7e5e78b96);
    			matches.addAll(_729e1e034a67dc4cc06033eacb45bcee73ab7a38);
    			matches.addAll(_9b92f45c8f76e00a88a2cf1dd0454c5589b3c592);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x34";
    			String ruleInfo = "{title:Correlation rule test number 34}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_869b92e50d212a883577d747676e03c197527630.size() > 0 && _42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c.size() > 0 && _a0f744c232cc5faf1c8304e5deb90423da3c09fa.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_869b92e50d212a883577d747676e03c197527630);
    			matches.addAll(_42f84f8eafab3bc2c0bfa7decbc40d848c6c5d7c);
    			matches.addAll(_a0f744c232cc5faf1c8304e5deb90423da3c09fa);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x3";
    			String ruleInfo = "{title:Correlation rule test number 3}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_4abbfce16d018ffee88a2fb362482d42fe60a2a4.size() > 0 && _e43d2d7fb4254f8475ec5beb7beded9953d6f949.size() > 0 && _ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_4abbfce16d018ffee88a2fb362482d42fe60a2a4);
    			matches.addAll(_e43d2d7fb4254f8475ec5beb7beded9953d6f949);
    			matches.addAll(_ea9e8c8197d1b20eaaf147353b63e1b7000ad4b5);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x26";
    			String ruleInfo = "{title:Correlation rule test number 26}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_400ea6fef3e51b365f858cdfe024c89a704df2b2.size() > 0 && _0f54473c7180eeede35ee1ecde143d543f45b041.size() > 0 && _33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_400ea6fef3e51b365f858cdfe024c89a704df2b2);
    			matches.addAll(_0f54473c7180eeede35ee1ecde143d543f45b041);
    			matches.addAll(_33b67c5b8c98ce15c2ad44f7035bd5e412d70b3c);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x43";
    			String ruleInfo = "{title:Correlation rule test number 43}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3.size() > 0 && _0bddf658d6d6cdc030f57b934ae48ca380c54e9a.size() > 0 && _db2bd5c92ce2eb63f14cb78340626d37c6669974.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_19690cb5a752f0ccf9adc1df0ed71cefb5efe7a3);
    			matches.addAll(_0bddf658d6d6cdc030f57b934ae48ca380c54e9a);
    			matches.addAll(_db2bd5c92ce2eb63f14cb78340626d37c6669974);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x2";
    			String ruleInfo = "{title:Correlation rule test number 2}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_2fd282a998c1cea0117224bd7022ac651cddb2a0.size() > 0 && _c708369c931c7f1385247bca2448952a1705a3e4.size() > 0 && _6ae545c829e7aa07e363fcf3f089555c3f27417e.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_2fd282a998c1cea0117224bd7022ac651cddb2a0);
    			matches.addAll(_c708369c931c7f1385247bca2448952a1705a3e4);
    			matches.addAll(_6ae545c829e7aa07e363fcf3f089555c3f27417e);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x21";
    			String ruleInfo = "{title:Correlation rule test number 21}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_532071fc551da07f8c314f0cd0e7e749620e3240.size() > 0 && _398515f6c6d39388a88d617e8a8701e6f65cadb6.size() > 0 && _ee01889a1db83bde384147426bf71b820489dc91.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_532071fc551da07f8c314f0cd0e7e749620e3240);
    			matches.addAll(_398515f6c6d39388a88d617e8a8701e6f65cadb6);
    			matches.addAll(_ee01889a1db83bde384147426bf71b820489dc91);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x24";
    			String ruleInfo = "{title:Correlation rule test number 24}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_cde203ca62887942a7c6b9c48e06413551e96db0.size() > 0 && _07e5e9e8ecda5a374553d9d6d8825d2852b01055.size() > 0 && _9ed44ed82c793239a8d138832d4079f6e1ab204d.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_cde203ca62887942a7c6b9c48e06413551e96db0);
    			matches.addAll(_07e5e9e8ecda5a374553d9d6d8825d2852b01055);
    			matches.addAll(_9ed44ed82c793239a8d138832d4079f6e1ab204d);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x22";
    			String ruleInfo = "{title:Correlation rule test number 22}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_326dc6ca1a4b857b796f4fbaaca0a741539702c1.size() > 0 && _2ab2471852138580321e2768eb86006313ddd34d.size() > 0 && _8bcde9c575d4a4d7b20df07e47395d398ace53d3.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_326dc6ca1a4b857b796f4fbaaca0a741539702c1);
    			matches.addAll(_2ab2471852138580321e2768eb86006313ddd34d);
    			matches.addAll(_8bcde9c575d4a4d7b20df07e47395d398ace53d3);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x8";
    			String ruleInfo = "{title:Correlation rule test number 8}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_157e5c94c2a5d389ad2d917e45325456565d01a3.size() > 0 && _083d95bb2055cb63ae6e0bc7044065055ff12365.size() > 0 && _ea4ac288269be3260f9ed4b5d347697e3be476cc.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_157e5c94c2a5d389ad2d917e45325456565d01a3);
    			matches.addAll(_083d95bb2055cb63ae6e0bc7044065055ff12365);
    			matches.addAll(_ea4ac288269be3260f9ed4b5d347697e3be476cc);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x11";
    			String ruleInfo = "{title:Correlation rule test number 11}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_b133ab180b1fb60959d04719654385e01e077a4d.size() > 0 && _de4503a22877f834c4220bbae5edbb204de94b5e.size() > 0 && _5441f73c76eb60aeaa8f896a16a991c825b8b0c5.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_b133ab180b1fb60959d04719654385e01e077a4d);
    			matches.addAll(_de4503a22877f834c4220bbae5edbb204de94b5e);
    			matches.addAll(_5441f73c76eb60aeaa8f896a16a991c825b8b0c5);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x17";
    			String ruleInfo = "{title:Correlation rule test number 17}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf.size() > 0 && _f0e853cdbba7fcca08a85c084450255f02d0b03b.size() > 0 && _3ef39f6a40e145812ed9e15439bf4e7b3fe345ad.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_853f8caf6db6212bdbc4d6f5d9f7d7e81202baaf);
    			matches.addAll(_f0e853cdbba7fcca08a85c084450255f02d0b03b);
    			matches.addAll(_3ef39f6a40e145812ed9e15439bf4e7b3fe345ad);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x39";
    			String ruleInfo = "{title:Correlation rule test number 39}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}

		if (_c95d98b19dfc53a078269b7dd33acc21d9b0918f.size() > 0 && _3b42753262a535cd129059572fdc9bffbfb3eb5d.size() > 0 && _a58273dd3c10b0da0e07d5e354f44ea02446a4d5.size() > 0) {
    			ArrayList<String> matches = new ArrayList<String>();
    			matches.addAll(_c95d98b19dfc53a078269b7dd33acc21d9b0918f);
    			matches.addAll(_3b42753262a535cd129059572fdc9bffbfb3eb5d);
    			matches.addAll(_a58273dd3c10b0da0e07d5e354f44ea02446a4d5);
    			String ruleId = "12345678-abcd-1234-abcd-123456789x30";
    			String ruleInfo = "{title:Correlation rule test number 30}";
    			String severity = "high";
    			createAlarm(matches, ruleInfo, ruleId, severity);
		}
    		
    		String ret = countAlarms + " alarms created by rules: " + alarms.toString();
    		countAlarms = 0;
    		alarms = new ArrayList<String>();
    		logger.log("Result: " + ret);
		return ret;
	}

	private ArrayList<String> getAlert(String rc_id, String timeframe) {
		Table table = dynaDB.getTable("AlertDB");
		long days = 0;
		long hours = 0;
		long minutes = 0;
		long tframe = Long.parseLong(timeframe.substring(0, timeframe.length() - 1));
		
		if (timeframe.endsWith("d")) {
			days = tframe;
		} else if (timeframe.endsWith("h")) {
			hours = tframe;
		} else if (timeframe.endsWith("m")) {
			minutes = tframe;
		}
		long startTimeMilis = (lambda_ts - (((days*24L*60L) + (hours*60L) + minutes) * 60L * 1000L));
		Date tempTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		tempTime.setTime(startTimeMilis);
		String startTimeStr = df.format(tempTime);
		tempTime.setTime(lambda_ts);
		String endTimeStr = df.format(tempTime);
		
		QuerySpec spec = new QuerySpec()
		        .withKeyConditionExpression("id = :v_id and rt between :v_start_dt and :v_end_dt")
		        .withValueMap(new ValueMap()
		        	.withString(":v_id", rc_id)
		        	.withString(":v_start_dt", startTimeStr)
		        	.withString(":v_end_dt", endTimeStr));
		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		ArrayList<String> itemsList = new ArrayList<String>();
		//itemsList.add("timestamp");
		while (iterator.hasNext()) {
		    itemsList.add(iterator.next().toJSON());
		}
		//long lambda_ts_fin = System.currentTimeMillis() - lambda_ts;
		//itemsList.set(0,String.valueOf(lambda_ts_fin));
		return itemsList;
	}

	private void createAlarm(ArrayList<String> events, String ruleInfo, String cr_id, String severity) {
		Date tempTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
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
		countAlarms++;
		alarms.add(cr_id);
	}
}

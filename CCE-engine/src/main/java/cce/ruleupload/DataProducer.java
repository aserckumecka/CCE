package cce.ruleupload;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

import org.json.JSONObject;

public class DataProducer implements Runnable{
	private BlockingQueue<JSONObject> queue;
	int runfor = 0;
	int eps;
	int eventid = 0;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
    
	Thread binThread=null;
    String dvchost = "";
    String[] msg = {
    		"Authentication blocked", 
    		"Failed login", 
    		"Login authorized", 
    		"Failed connection", 
    		"New user created",
    		"Email sent using root account",
    		"Attempt to access protected file",
    		"Admin account failed login",
    		"FTP connection from unknown user",
    		"SSH failed attempt"};
    
	public DataProducer(String dvchost, BlockingQueue<JSONObject> queue, int eps, int runfor) {
		this.dvchost = dvchost;
    	this.queue = queue;
    	this.eps = (int) (eps*0.85);
    	this.runfor = runfor;
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		long endTime;
		int count = 0;
		long difTime = 0;
		long starttime = System.currentTimeMillis();
		JSONObject evt;
		
		while((System.currentTimeMillis() - starttime) < runfor) {
			while(count < eps) {
				evt = createEvent();
				queue.add(evt);
				count++;
			}
			count = 0;
			endTime = System.currentTimeMillis();
			difTime = endTime - startTime;
			startTime = endTime;
			if(difTime < 1000) {
				try {
					Thread.sleep(1050 - difTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public JSONObject createEvent() {
		Date tempTime = new Date();
	    String rt = df.format(tempTime);
	    int oct3 = new Random().nextInt(256);
	    int oct4 = new Random().nextInt(256);
	    String src_ip = "192.168."+oct3 + "." + oct4;
	    String dst_ip = "172.25."+oct3 + "." + oct4;
	    String dvc = "10.0."+oct3 + "." + oct4;
	    String dhost = "dhost"+oct3;
	    String duser = "duser"+oct3;
	    String newMsg = msg[new Random().nextInt(10)];
	    eventid++;
	    try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String ret = "{\"eventid\": "+eventid+", \"src_ip\": \""+src_ip+"\", \"dst_ip\": \""+
		dst_ip+"\", \"dvchost\": \""+dvchost+"\", \"dvc\": \""+dvc+"\", \"dhost\": \""+
		dhost+"\", \"msg\": \""+newMsg+"\", \"duser\": \""+duser+"\", \"rt\": \""+rt+"\"}";

		return new JSONObject(ret);
	}
	
	// Not in use by CCE...
	public void genRule(int nRules) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		int count = 0;
		
		String title = "title: Testing rule number " + count;
		String id = "id: 953b895e-5cc9-454b-b183-7f3db555452e";
		String status = "status: experimental";
		String description = "description: Detects Malleable Amazon Profile";
		String references = "references:";
		String ref1 = "  - 'https://github.com/rsdsre/testing_rules/"+id+"'";
		String author = "author: Adriano Serckumecka";
		String tags = "tags:";
		String tag1 = "  - attack.t1102";
		String logsource = "logsource:";
		String cat = "  category: proxy";
		String dev = "  device: squid";
		String detection = "detection:";
		String det = "  xxxxxx";
		String cond = "  yyyyyy";
		String tf = "timeframe: 60m";
		String fp = "falsepositives:";
		String fp1 = "  - Unknown";
		String level = "level: high";
	}
}

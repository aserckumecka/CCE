package cce.ruleupload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.json.JSONObject;

public class DatasetGen {
		
	public static void main(String[] args) {
		HashMap<String, BlockingQueue<JSONObject>> binsHM = new HashMap<String, BlockingQueue<JSONObject>>();
		HashMap<String, String[]> devicesHM = new HashMap<String, String[]>();
		List<String> devices = null;
		Path javaCodePath = Paths.get(System.getProperty("user.dir") + "/devices.txt");
		try {
			devices = Files.readAllLines(javaCodePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String device : devices) {
			String[] temp = device.split(",");
			String dev = temp[0];
			String bin = temp[temp.length-1];
			String[] temp2 = new String[2];
			temp2[0] = bin;
			temp2[1] = temp[1];
			devicesHM.put(dev, temp2);
			if (binsHM.get(bin) == null) {
				binsHM.put(bin, new ArrayBlockingQueue<>(5000));
			}
		}
		
		Path binCapacity = Paths.get("bin_capacity.txt");
		String bc = null;
		try {
			bc = Files.readString(binCapacity);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int bincap = Integer.parseInt(bc.strip());
		int runfor = 120000;
		
		// consumers...
		for (Map.Entry<String,BlockingQueue<JSONObject>> bin : binsHM.entrySet()) {
			//Thread thread = new Thread(new DataConsumer(bin.getKey(), bin.getValue(), bincap, runfor));
			//System.out.println("Starting bin consumer: " + bin.getKey());
			//thread.start();
		}
		
		// producers...
		for (Map.Entry<String,String[]> dev : devicesHM.entrySet()) {
			String bin = dev.getValue()[0];
			int eps = Integer.parseInt(dev.getValue()[1]);
			Thread thread = new Thread(new DataProducer(dev.getKey(), binsHM.get(bin), eps, runfor));
			System.out.println("Starting dev producer: " + dev.getKey() + " to bin " + bin);
			thread.start();
		}
		Thread thread = new Thread(new LambdaTriggerCorrelation("correlation", bincap, 0));
		thread.start();
	}
}

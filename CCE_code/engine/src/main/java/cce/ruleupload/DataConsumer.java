package cce.ruleupload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.json.JSONArray;
import org.json.JSONObject;

import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConsumer implements Runnable{
	private ArrayList<BlockingQueue<JSONObject>> queueArray;
	private String binName;
	private double triggerGap;
	JSONArray block = new JSONArray();
	String sblock = "";
	int runfor = 0;
	public ArrayList<JSONArray> blockArray = new ArrayList<JSONArray>();
	
	
	public DataConsumer(String binName, ArrayList<BlockingQueue<JSONObject>> queueArray, int triggerGap, int runfor) {
		this.queueArray = queueArray;
		this.binName = binName;
		this.triggerGap = triggerGap;
		this.runfor = runfor;
	}
	
	public void run() {
		Path rulePath = Paths.get("events/"+binName+".json");
		byte[] peB = "".getBytes();
		try {
			Files.write(rulePath, peB, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		double lambdaTriggerStartTime = System.currentTimeMillis();
		double starttime = lambdaTriggerStartTime;
		int triggerCount = 1;
		
		
		for (BlockingQueue<JSONObject> queue : queueArray) {
			blockArray.add(new JSONArray());
		}
		
		
		while((System.currentTimeMillis() - starttime) < runfor) {
			for (int i = 0; i < queueArray.size(); i++) {
				new Thread(new QueueConsumer(queueArray.get(i), blockArray.get(i), i)).start();
			}
			try {
				Thread.sleep((long) triggerGap);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for (JSONArray jsonArray : blockArray) {
				block.putAll(jsonArray);
			}
			String blockLT = block.toString();
			int blockLTsize = block.length();
			block.clear();
			
			new Thread(new LambdaTrigger(binName, blockLT, triggerCount, blockLTsize, (int)triggerGap)).start();
			
			for (BlockingQueue<JSONObject> queue : queueArray) {
				System.out.println("Queue size: " + queue.size());
			}
			new Thread(new WriteToDisk(rulePath, blockLT)).start();
			triggerCount++;
			
		}
	}
	
	
	class QueueConsumer implements Runnable{
		BlockingQueue<JSONObject> queue;
		JSONArray block = new JSONArray();
		String sblock = "";
		double startTime;
		int i;
		
		public QueueConsumer(BlockingQueue<JSONObject> queue, JSONArray block, int i) {
			this.queue = queue;
			this.i = i;
			startTime = System.currentTimeMillis();
		}

		public void run() {
			while((System.currentTimeMillis() - startTime) < triggerGap) {
				if(queue.peek() != null) {
					block.put(queue.poll());
				}
			}
			blockArray.set(i, block);
		}
	}
	
	
	
	
	
	class WriteToDisk implements Runnable{
		Path rulePath;
		JSONArray bl;
		String sblock = new String();
		
		public WriteToDisk(Path rulePath, String sblock) {
			this.rulePath = rulePath;
			this.sblock = sblock;
		}
		
		public void run() {
			/*
			List<String> evts = new ArrayList<String>();
			for (int i = 1; i < bl.length(); i++) {
				evts.add(bl.getString(i));
				System.out.println("Evt " + bl.getString(i));
			}
			*/
			byte[] dataBytes = sblock.toString().getBytes();
			
			try {
				Files.write(rulePath, dataBytes, StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


package old;

import java.text.SimpleDateFormat;
import java.util.Date;


public class temp {
	long lambda_ts = System.currentTimeMillis();

	private void getAlert(String timeframe) {
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
		System.out.println("lambda_ts " + lambda_ts);
		System.out.println("startTimeMilis " + startTimeMilis);
		Date tempTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		tempTime.setTime(startTimeMilis);
		String startTimeStr = df.format(tempTime);
		System.out.println("startTimeStr " + startTimeStr);
		tempTime.setTime(lambda_ts);
		String endTimeStr = df.format(tempTime);
		System.out.println("endTimeStr " + endTimeStr);
	}

	public static void main(String args[]) {
		temp t = new temp();
		t.getAlert("1m");
	}
	
}

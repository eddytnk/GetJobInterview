package com.getjobinterviewEMS.GetJobInterviewEMS.services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sendSMSService {
	
	public String sendSms(String sender, String msg, String number) throws Exception{
	
			// Construct data
			String user = "username=" + "youremail@address.com";
			String hash = "&hash=" + "Your API hash";
			
			String message = "&message=" + msg;
			String sdr = "&sender=" + sender;
			String numbers = "&numbers=" + number;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.txtlocal.com/send/?").openConnection();
			String data = user + hash + numbers + message + sdr;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		
	}
}
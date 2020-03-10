package com.qac.sensors.pysical;

import java.io.*;
import com.qac.sensors.Sensor;

public class BluetoothListener extends Sensor<Boolean>{
	private static final int ID = 5;
	
	String s = null;
	boolean conn = false;

	public BluetoothListener(){
		super(ID);
	}

	@Override
	public void init() {
	}

	@Override
	public Boolean getReading(){

		try {
			Process p = Runtime.getRuntime().exec("hcitool con");	
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while((s = stdInput.readLine()) != null){
				if(s.contains("00:15:83:00:43:EC")){
					System.out.println("Connection to headunit was successful!");
					conn = true;
				}
			}
			if(conn == false){
				System.out.println("Connection to headunit was not successful!");
			}

                        
		} 
		catch (IOException e) {
			System.out.println(e);
		}

		return conn;
		
	}

}

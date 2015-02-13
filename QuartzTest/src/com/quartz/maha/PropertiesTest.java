package com.quartz.maha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(5);
		ScheduledFuture<?> t;
		
		Job1 j = new Job1();
	    t = stpe.scheduleAtFixedRate(j, 0, 5, TimeUnit.SECONDS);
	    
	    
	}
	
}

class Job1 implements Runnable {
	public static Properties p;
	public static Boolean interrupt;
	public Job1() throws FileNotFoundException, IOException{
		p = new Properties();
		p.load(new FileInputStream("Config.properties"));
	}
	public void run() {
		interrupt = Boolean.parseBoolean(p.getProperty("interrupt"));
		System.out.println("Interrupt Value : ");
		if (!interrupt)
			System.out.println("Job 1");
	}
}
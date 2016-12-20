package com.wsjonly.concurrency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

public class SDFThreadsafeDemo {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	
	private final static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd-yyyy");
		}
	};
	
	private static String[] dates = {"11-09-1990", "06-22-1992", "31-05-2015"};
	
	public static void main(String[] args) {
		
		System.out.println("Start:");
		Thread t1 = new Thread(new SDF());
		Thread t2 = new Thread(new SDF());
		Thread t3 = new Thread(new SDF());
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static class SDF implements Runnable{
		
		public  void run() {
			// TODO Auto-generated method stub
			for(String date: dates){
				try {
					System.out.println((threadLocal.get()).parse(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}

package com.wsjonly.concurrency;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SDFNotThreadsafeDemo {

	private final static SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

	private static String[] stringDates = { "21-12-2012", "10-10-2013", "23-02-2014" };

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());
		t1.start();
		t2.start();
		t3.start();
	}

	private static class MyThread implements Runnable {

		public void run() {
			for (String strDate : stringDates) {
				try {
//					synchronized (sdf1) {
						System.out.println(sdf1.parse(strDate));
//					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
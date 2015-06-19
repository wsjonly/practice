package com.weng.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class ThreadC implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
		}
	}
	
}
public class MutiCpuListening {
	public static void main(String[] args) {
		ExecutorService service =  Executors.newFixedThreadPool(2);
		for (int i = 0; i < 2; i++) {
			service.execute(new ThreadC());
		}
		
	}
}

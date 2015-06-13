package com.weng.concurrentTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class ThreadA implements Runnable {

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
			service.execute(new ThreadA());
		}
		
	}
}

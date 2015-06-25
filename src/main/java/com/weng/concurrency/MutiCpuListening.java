package com.weng.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.annotation.ThreadSafe;



class ThreadC implements Runnable {
	int i;
	public ThreadC(int i) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}
//	@GuardedBy("this")
	public void run() {
		// TODO Auto-generated method stub
		synchronized (ThreadC.class) {
			while(true){
				System.out.print(i);
			}
		}
	}
	
}
public class MutiCpuListening {
	public static void main(String[] args) {

		
		ExecutorService service =  Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			service.execute(new ThreadC(i));
		}
		
	}
}

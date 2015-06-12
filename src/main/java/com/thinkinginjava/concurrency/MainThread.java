package com.thinkinginjava.concurrency;

public class MainThread {
	public static void main(String[] args) {
//		Thread t =  new Thread( new LiftOff());
//		t.start();
//		
//		Thread t2 =  new Thread( new LiftOff());
//		t2.start();
		for(int i=0; i<5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("waiting for LiftOff");
		
	}
}

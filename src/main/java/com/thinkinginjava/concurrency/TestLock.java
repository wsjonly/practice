package com.thinkinginjava.concurrency;

import java.util.HashMap;

public class TestLock {

	private HashMap map = new HashMap();
	
	public TestLock() {
		for(int i=0;i<10;i++) {
			Thread t = new Thread(String.valueOf(i)) {
				public void run() {
					for (int j = 0; j < 10000000; j++) {
						map.put(new Integer(j), j);
					}
	
					System.out.println("t" + this.getName() + " over");
				}
			};
			t.start();
		}
	}

	public static void main(String[] args) {
		new TestLock();
	}
}
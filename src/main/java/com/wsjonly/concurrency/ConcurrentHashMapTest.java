package com.wsjonly.concurrency;

import java.util.HashMap;
import java.util.UUID;

public class ConcurrentHashMapTest {
	static final HashMap<String, String> map = new HashMap<String, String>(2);

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							// for (int j = 0; j < 100; j++) {
							map.put(UUID.randomUUID().toString(), "");
							// }
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(map.keySet());
		System.out.println("OVER!");
	}
}

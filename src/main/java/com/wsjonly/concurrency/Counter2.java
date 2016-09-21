package com.wsjonly.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Counter2 {
	public static Map<Long, Long> map = new ConcurrentHashMap<Long, Long>();

	public static long counter(long userId) {
		if (map.putIfAbsent(userId, (long) 1) == null) {
			System.out.println("error");
			return 1;
		} else {
			for (;;) {
				long x = map.get(userId);
				if (map.replace(userId, x, x + 1)) {
					return x + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int j = 0; j < 10000; j++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 10000; i++) {
						Counter2.counter(9999);
						// Counter.counter(8888);
					}

				}
			});
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(map.get((long) 9999));
		System.out.println(map.get((long) 8888));
	}
}

package com.wsjonly.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	public static final Map<Long, Long> map = new ConcurrentHashMap<Long, Long>();
	public static final Lock lock = new ReentrantLock();

	public static long counter(long userId) {
		//
		if (!map.containsKey(userId)) {
			lock.lock();
			try {
				if (map.containsKey(userId)) {
					for (;;) {
						long x = map.get(userId);
						if (map.replace(userId, x, x + 1)) {
							return x + 1;
						}
					}
				} else {
					map.put(userId, (long) 1);
					return 1;
				}
			} finally {
				lock.unlock();
			}
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
		for (int j = 0; j < 100; j++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 10000; i++) {
						Counter.counter(9999);
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
	}
}

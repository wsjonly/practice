package com.wsjonly.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadTest implements Runnable {
	static Lock lock = new ReentrantLock();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lock.lock();
		try {
			for (int i = 0; i < 100; i++) {
				lock.lock();
				try {
					System.out.print(i + " ");
					try {
						lock.lockInterruptibly();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					lock.unlock();
				}
			}
			System.out.println();
		} finally {
			lock.unlock();
		}
	}
}

public class ReentrantLockTest {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			es.submit(new ThreadTest());
		}
		es.shutdown();
	}
}

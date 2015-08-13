package com.wsjonly.concurrency.lock;

import java.util.concurrent.atomic.AtomicReference;


public class SpinLock {
	private AtomicReference<Thread> owner = new AtomicReference<Thread>();
	
	public void lock() {
		Thread thread = Thread.currentThread();
		while (owner.compareAndSet(null, thread)) {
			
		}
	}
	
	public void unlock() {
		Thread  thread = Thread.currentThread();
		while (owner.compareAndSet(thread, null)) {
			
		}
	}
	
}

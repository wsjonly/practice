package com.wsjonly.concurrency.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SimpleReentrantLock extends AbstractQueuedSynchronizer {

	private static final long serialVersionUID = -960613698093455583L;

	public SimpleReentrantLock() {

	}

	protected boolean tryAcquire(int unused) {
		if (compareAndSetState(0, 1)) {
			setExclusiveOwnerThread(Thread.currentThread());
			return true;
		}
		
		return false;
	}
	
	protected boolean tryRelease(int unused) {
		setExclusiveOwnerThread(null);
		setState(0);
		return true;
	}
	
	
	public void lock() {
		acquire(1);
	}
	
	public void unlock() {
		release(1);
	}
	
	public boolean isLocked() {
		return isHeldExclusively();
	}
	
	public boolean tryLock() {
		return tryAcquire(1);
	}
	
	
	public static void main(String[] args) {
		final SimpleReentrantLock lock = new SimpleReentrantLock();
		lock.lock();
		for (int i=0; i<10; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					lock.lock();
					System.out.println("thread:" + Thread.currentThread().getId() + " acquired the lock");
					
					lock.unlock();
				}
			}).start();
		}
		lock.unlock();
		
		
		
		
	}
}

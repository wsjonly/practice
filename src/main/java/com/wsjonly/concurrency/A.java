package com.wsjonly.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.MappingException;

public class A implements Runnable{
	
	int count = 0;
	static Lock lock = new ReentrantLock();
	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			lock.lock();
			
			while(true) {
				System.out.println(Thread.currentThread().getName() + " "
						+ count);
				TimeUnit.SECONDS.sleep(1);
				count++;
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService excutors = Executors.newFixedThreadPool(2);
		excutors.execute(new A());
		excutors.execute(new A());
	}
}

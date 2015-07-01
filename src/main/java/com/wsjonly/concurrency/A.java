package com.wsjonly.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.MappingException;

public class A implements Runnable{
	
	int count = 0;
	final static Lock lock = new ReentrantLock();
	@Override
	public void run() {
		lock.lock();
		try {
			// TODO Auto-generated method stub
			
			while(count < 5) {
				System.out.println(Thread.currentThread().getName() + " "
						+ count);
				TimeUnit.SECONDS.sleep(1);
				count++;
			}
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle exception
			lock.unlock();
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService excutors = Executors.newFixedThreadPool(2);
		Future<Integer> future = excutors.submit(new C());
		Future<Integer> future2 = excutors.submit(new C());
		System.out.println(future.get());
		System.out.println(future2.get());
		excutors.shutdown();
		
//		
//		excutors.execute(new A());
//		excutors.execute(new A());
		
	}
}

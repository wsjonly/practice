package com.weng.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.MappingException;

public class A<K, V> {
	
	public A(){
		
	}
	public A(Map<? extends K, ? extends V> m){
		
	}
	
	
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "AAAA");
		map.put(2, "BBBB");
		map.put(3, "CCCC");
		map.put(4, "DDDD");
//		System.out.println(map);
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.println(me.getValue());
		}
		
		
		Lock lock = new ReentrantLock();
		try{
			lock.lock();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}

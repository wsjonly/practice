package com.wsjonly.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private int cacheSize;

	public LRUCache(int cacheSize) {
//		super(16, 0.75, true);
		this.cacheSize = cacheSize;
	}

	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}
	
	public static void main(String[] args) {
		LRUCache<String, Integer> cache = new LRUCache<String, Integer>(3);
		cache.put("0", 0);
		cache.put("1", 1);
		cache.put("2", 2);
		System.out.println(cache);
		cache.put("4", 4);
		System.out.println(cache);
		cache.put("5", 5);
		System.out.println(cache);
	}
}
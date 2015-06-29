package com.weng.map;

import java.util.Set;

public interface MMap<K, V> {
	int size();
	boolean isEmpty();
	boolean equals(Object o);
	boolean containsKey(Object key);
	boolean containsValue(Object value);
	V get(Object key);
	V put(Object key, Object value);
	V remove(Object key);
	int hashCode();
	void putAll(MMap<? extends K, ? extends V> m);
	
	interface Entry<K, V>{
		K getKey();
		V getValue();
		V setValue(V value);
		boolean equals(Object o);
		int hashCode();
	}
	
	Set<K> keySet();
	Set<MMap.Entry<K, V>> entrySet();
}

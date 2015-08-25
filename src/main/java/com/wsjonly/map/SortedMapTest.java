package com.wsjonly.map;

import java.util.Map;
import java.util.TreeMap;

public class SortedMapTest {
	public static void main(String[] args) {
		Map map = new TreeMap();
		map.put("3", "a");
		map.put("1", "b");
		map.put("2", "c");
		map.put("1", "n");
//		map.put(1, "d");
		System.out.println(map);
	}
}

package com.wsjonly.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(){{
			put("0", "zero");
			put("1", "one");
			put("2", "two");
			put("3", "three");
		}
		};
		
		System.out.println(map.toString());
		System.out.println(map.entrySet());
		Iterator<Entry<String, String>> ite = map.entrySet().iterator();
	}
}

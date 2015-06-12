package com.weng.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
	public static final Map<String, String> mapUs = new HashMap<String, String>(){
		{
			put("", "");
		}
	};
	
	
	public static final List<String> listS = new ArrayList<String>(){
		{
			add("xxx");
		}
	};
	
//	public static Ma
	
	public static void main(String[] args) {
		Map map = new HashMap(){
			@Override
			public Object put(Object key, Object value) {
				// TODO Auto-generated method stub
				return super.put(key, value + "xxx");
			}
		};

		map.put("xx", "hello");
		System.out.println(map.get("xx"));
	}
}

package com.weng.jsonobject;

import net.sf.json.JSONObject;


public class Main {
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put(1, "b");
		json.put("2", "ok");
		json.put("xx", "1");
		System.out.println(json.toString());
		System.out.println(json.getInt("xx"));
		A a = new A();
		a.setAge(24);
		a.setName("shijinweng");
		json.put("profile", "");
//		JSONObject json2 = json.getJSONObject("profile");
		System.out.println(json);
	}
}

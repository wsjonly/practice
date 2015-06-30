package com.wsjonly.practice.proxy;

public class SimplePojo implements Pojo {
	
	private static SimplePojo obj = null;
	private SimplePojo(){
		
	}
	
	public static SimplePojo getInstance(){
		if (obj==null) {
			obj = new SimplePojo();
		}
		return obj;
	}
	public void foo() {
		// TODO Auto-generated method stub
		this.bar();
	}

	public void bar() {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
	}
	
}

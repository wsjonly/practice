package com.weng.reflection;

public class LoadFilePath {
	public LoadFilePath(){
		System.out.println("init");
		System.out.println(this.getClass().getClassLoader().getResourceAsStream("applicationContext.xml"));
		System.out.println(this.getClass().getResourceAsStream("/applicationContext.xml"));
		System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("applicationContext.xml"));
		
		System.out.println(this.getClass().getResource("/"));
		System.out.println(this.getClass().getClassLoader().getResource(""));
		this.getClass().getClassLoader();
		System.out.println(ClassLoader.getSystemClassLoader());
	}
	public static void main(String[] args) {
		new LoadFilePath();
	}
}

package com.wsjonly.classloader;

import java.util.HashMap;

public class ClassLoaderTest {
	public static void main(String[] args) {
		System.out.println("ok");
		System.out.println(ClassLoaderTest.class.getClassLoader());
		System.out.println(HashMap.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());

	}
}

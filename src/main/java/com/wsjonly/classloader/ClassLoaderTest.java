package com.wsjonly.classloader;

import java.util.HashMap;

public class ClassLoaderTest {
	public static void main(String[] args) {
		System.out.println(ClassLoaderTest.class.getClassLoader());
		System.out.println(HashMap.class.getClassLoader());
	}
}

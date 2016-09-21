package com.wsjonly.jvm.outofmemory;

import java.util.Vector;

public class MemoryLeakage {
	static Vector v = new Vector();

	public static void test() {
		for (int i = 1; i < 100; i++) {
			Object o = new Object();
			v.add(o);
			o = null;
		}
	}

	public static void main(String[] args) {

	}
}

package com.wsjonly.jvm;

public class ConstantPool {
	public static void main(String[] args) {
		Integer a = (Integer) 30;
		Integer b = (Integer) 30;
		System.out.println(a == b); // true
		Integer a1 = (Integer) 200;
		Integer b1 = (Integer) 200;
		System.out.println(a1 == b1); // false
		Integer a2 = (Integer) 127;
		Integer b2 = (Integer) 127;
		System.out.println(a2 == b2); // true
		Integer a3 = (Integer) 128;
		Integer b3 = (Integer) 128;
		System.out.println(a3 == b3); // false

		for (int i = -1000; i < 10000; i++) {
			Integer i1 = (Integer) i;
			Integer i2 = (Integer) i;
			if (i1 == i2) {
				System.out.print(i + " ");
			}
		}
	}
}

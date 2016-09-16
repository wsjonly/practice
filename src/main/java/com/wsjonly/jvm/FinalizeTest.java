package com.wsjonly.jvm;

public class FinalizeTest {
	protected void finalize() {
		System.out.println("垃圾回收前这个方法会被执行"); //只会被执行一次
	}

	public static void main(String[] args) {
		FinalizeTest f = new FinalizeTest();
		f = null;
		System.gc();
		
		f = new FinalizeTest();
		System.gc();
		
		// System.out.println("OK");

		 while (true) {
		
		 }
	}
}

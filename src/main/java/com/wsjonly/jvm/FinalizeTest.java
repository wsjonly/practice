package com.wsjonly.jvm;

public class FinalizeTest {
	protected void finalize() {
		System.out.println("��������ǰ��������ᱻִ��"); //ֻ�ᱻִ��һ��
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

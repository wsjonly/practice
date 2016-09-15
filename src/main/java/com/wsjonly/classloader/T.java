package com.wsjonly.classloader;

class CL {
	public static final int Y = 1000;
	public static int X = 100;
	static {
		System.out.println("static in T x=" + X);
	}
	
	static {
		System.out.println("2nd static in T");
	}

	public void hello() {
		System.out.println("hello world");
	}

}

public class T {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		T t = (T) Class.forName("com.wsjonly.classloader.T").newInstance();
		System.out.println(CL.X);
	}
}
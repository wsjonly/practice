package com.wsjonly.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodInvokeUtils {
	public static void singletonClassExample() throws Exception {

		Class<?> cls = Class.forName("java.lang.Runtime");
		Runtime runtime = Runtime.getRuntime();

		for (Method method : cls.getDeclaredMethods()) {
			System.out.println("method name:-------" + method.getName() + "-------");
			if (method.getGenericParameterTypes().length == 0
					&& !Modifier.toString(method.getModifiers()).contains("private")) {
				System.out.println(method.invoke(runtime, null));
			}
			// System.out.println(method.getTypeParameters());
			System.out.println("--------------------------------------------");
			// method.invoke(runtime, null);
		}

	}

	public static void main(String[] args) throws Exception {
		singletonClassExample();
	}
}

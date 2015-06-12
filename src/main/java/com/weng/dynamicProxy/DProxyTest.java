package com.weng.dynamicProxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DProxyTest {
	public static void main(String[] args){
		DProxyDao dao = new DProxyDaoImpl();
		System.out.println(dao.getClass().getClassLoader());
		System.out.println( dao.getClass().getInterfaces());
		Class<?>[] interfaces = dao.getClass().getInterfaces();
		for(Class<?> c : interfaces){
			System.out.println(c.getName());
		}
		
		DProxyDao dproxy = (DProxyDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(),
				new SayInvocation(dao));
		
		System.out.println(dproxy);
		dproxy.saySomething();
		dproxy.doSomething();
		
	}

}

package com.weng.practice.proxy;


import org.springframework.aop.framework.ProxyFactory;

public class Main {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory(SimplePojo.getInstance());
		factory.addInterface(Pojo.class);
//		factory.addAdvice();
		Pojo pojo = (Pojo) factory.getProxy();
		pojo.foo();
	}
}

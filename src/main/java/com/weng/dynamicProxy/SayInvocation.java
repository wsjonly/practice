package com.weng.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SayInvocation implements InvocationHandler {
	Object obj;
	
	public SayInvocation(Object obj){
		this.obj = obj;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		Object result;
		
		result = method.invoke(obj, args);
		return result;
	}

}

package com.wsjonly.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class C implements Callable<Integer> {
	int s = 0;
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		
		for (int i=0; i<10; i++) {
			s += i;
		}
		TimeUnit.SECONDS.sleep(1);
		return s;
	}

}

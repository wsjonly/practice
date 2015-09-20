package abtest;

import java.util.concurrent.Callable;

import com.wsjonly.concurrency.ConcurrentHashMap;

public class A implements Callable<Integer> {
	private static int total = 2000000;
	private static int every = 1000;
	private String userId;
	private int num;
	private static ConcurrentHashMap<String, Integer> buyMap = new ConcurrentHashMap<String, Integer>();

	public A(String userId, int num) {
		this.userId = userId;
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub

		return isBuyed();
	}

	private Integer isBuyed() {
		// TODO Auto-generated method stub
		if (total - num * every >= 0) {
			buyMap.put(this.userId, this.every * this.num);
			total -= this.every * this.num;
		} 
		
		return total / every;
	}

}

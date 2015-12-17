package com.wsjonly.callback;



public class AsynCallbackTask {
	
	public <T> void executeAction(final Callback<T> call) {
		System.out.println(Thread.currentThread().getName() + " in action");
		
		Thread task = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hello world");
				System.out.println(Thread.currentThread().getName() + " in run");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				T result = call.doAction();
				if(result instanceof String) {
					System.out.println("the result: " + result );
				}
				System.out.println("goodbye world");
			}
			
		});
		
		task.start();
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		new AsynCallbackTask().executeAction(new Callback<String>() {
			@Override
			public String doAction() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + " is called back in Test");
				return "asynchronized callback succeed";
			}
			
		});
		
		System.out.println("Done");
	}
}

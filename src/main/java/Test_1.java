import org.hibernate.context.internal.ThreadLocalSessionContext;


public class Test_1 {
	private int i = 0;
	
	public Test_1(int i){
		this.i = i;
		System.out.println(this.i);
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		new Test_1(5);
	}
}

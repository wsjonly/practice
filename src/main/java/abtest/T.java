package abtest;

public class T {
	public static void main(String[] args) {
		int i = 0;
		long startTime = System.currentTimeMillis();
//		Long.MAX_VALUE
		System.out.println(Integer.MAX_VALUE);
		while(i < Integer.MAX_VALUE) {
			i++;
			if (i % 100000000 == 0) {
				System.out.println(System.currentTimeMillis() - startTime);
			}
		}
	}
}

package abtest;

public class T {
	public static void main(String[] args) {
		int i = 2;
		int j = 1;
		int k = 0;
		i = j = k;
		System.out.println(i + "," + j + " ," + k);

		for (;;) {
			System.out.println(1);
		}
	}
}

package abtest;

import java.util.HashSet;
import java.util.Scanner;

public class XX {
	public static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		set = getSet(n);
		int total = 0;
		for (int i = 2; i <= n / 2; i++) {
			if(set.contains(i) && set.contains(n-i)) total++;
		}
		System.out.println(total);
	}

	private static HashSet<Integer> getSet(int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		// TODO Auto-generated method stub
		hs.add(2);
		for (int i = 3; i <= n; i++) {
			boolean ok = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					ok = true;
					break;
				}
			}
			if (!ok) {
//				System.out.println(i);
				hs.add(i);
			}
		}
		return hs;
	}
	
	

	
	
	
}

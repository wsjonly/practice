package com.wsjonly.algorithm;

public class QuitSort {

	public static void quitsort(int[] a, int x, int y) {
		if (x >= y)
			return;
		int head = x;
		int tail = y;
		int k = a[x];
		while (x < y) {
			while (y > x && a[y] > k)
				y--;
			if (y > x) {
				a[x] = a[y];
				x++;
			}
			while (y > x && a[x] < k)
				x++;
			if (y > x) {
				a[y] = a[x];
				y--;
			}

		}
		a[x] = k;
		quitsort(a, head, x - 1);
		quitsort(a, y + 1, tail);

	}

	public static void main(String[] args) {
		int[] a = new int[100];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		quitsort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

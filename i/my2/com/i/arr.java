package com.i;

public class arr {
	public static void main(String[] args) {
		int a[][] = { { 1 }, { 1, 2, 3 }, { 12321 } };
		for (int i = 0; i < a.length; i++) {
			// System.out.println(i);
			for (int ii = 0; ii < a[i].length; ii++) {
				System.out.println(a[i][ii]);
			}
		}
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		for (int b : arr) {
			System.out.println(b);
		}

	}
}

package hr.sorting;

import java.util.Scanner;

public class CountingSort3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[100];
		for (int i = 0; i < n; i++) {
			ar[sc.nextInt()]++;
			sc.next();
		}
		int k = 0;
		for (int i = 0; i < 100; i++) {
			int j = ar[i];
			k += j;
			System.out.print(k + " ");
		}
	}
}

package hr.sorting;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		InsertionSort x = new InsertionSort();
		p = x.sort(p);
		for (int i = 0; i < n; i++) {
			System.out.println(p[i]);
		}
	}

	public int[] sort(int[] p) {
		int tmp, j;
		for (int i = 1; i < p.length; i++) {
			j = i;
			while (j > 0 && p[j] < p[j-1]) {
				tmp = p[j];
				p[j] = p[j - 1];
				p[j - 1] = tmp;
				j--;
			}
		}
		return p;
	}
}

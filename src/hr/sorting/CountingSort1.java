package hr.sorting;

import java.util.Scanner;

public class CountingSort1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[100];
		for (int i = 0; i < n; i++) {
			ar[sc.nextInt()]++;
		}
		
		for (int i = 0; i < 100; i++) {
			int j = ar[i];
			while (j > 0){
				System.out.print(i + " ");
				j--;
			}
		}
	}
}

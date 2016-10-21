package hr.sorting;

import java.util.Scanner;

public class QuickSort {

	public void sort(int[] p, int lo, int hi) {
		if (hi == lo)
			return;

		if (lo < hi) {
			int part = partition(p, lo, hi);
			
			// print elements of each recursive call
			for (int i = 0; i < p.length; i++) {
				System.out.print(p[i] + " ");
			}
			System.out.println();
			
			sort(p, lo, part - 1);
			sort(p, part + 1, hi);

		}
	}

	public int partition(int[] p, int lo, int hi) {
		int pivot = p[hi];
		int tmp;
		int i = lo;

		// Here 2 pointers start from the left side of the array(lo) and 
		// We iterate over j and i is incremented when we find an element(at j) less than the pivot and 
		// exchange it with the element at i. 
		for (int j = lo; j <= hi - 1; j++) {
			if (p[j] <= pivot) {
				tmp = p[i];
				p[i] = p[j];
				p[j] = tmp;
				i = i + 1;
			}
		}

		//The pivot is copied to the appropriate position
		tmp = p[hi];
		p[hi] = p[i];
		p[i] = tmp;

		return i;
	}

	private static int partition2(int[] arr, int x, int y) {
		int pivot = arr[x];
		int i = x;
		for (int p = x + 1; p <= y; p++) {
			if (arr[p] < pivot) {
				int temp = arr[p];
				for (int si = p - 1; si >= i; si--) {
					arr[si + 1] = arr[si];
				}
				arr[i] = temp;
				i++;
			}
		}
		return i;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		QuickSort x = new QuickSort();
		x.sort(p, 0, n - 1);
	}
}

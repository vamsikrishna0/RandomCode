package hr.sorting;

import java.util.Scanner;

public class MergeSort {
	//*Enhancement*
	//Insertion sort helps us out on smaller sub arrays.
	public void insertionSort(int[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
				exch(a, j, j - 1);
			}
		}
	}

	private void exch(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	//Implements the "conquer" step. Merge step
	public void merge(int[] a, int[] temp, int lo, int hi, int mid) {

		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++)
			temp[k] = a[k];
		for (int k = lo; k <= hi; k++) {
			if (lo > mid)
				a[k] = temp[j++];
			else if (j > hi)
				a[k] = temp[i++];
			else if (temp[i] < temp[j])
				a[k] = temp[i++];
			else
				a[k] = temp[j++];
		}
	}

	//Recursive function which implements the "divide" step.
	public void divide(int[] a, int[] temp, int lo, int hi) {
		if (hi <= lo)
			return;

		//This is also an enhancement to reduce the recursive overhead for smaller arrays
		if (hi - lo < 7) {
			insertionSort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		divide(a, temp, lo, mid);
		divide(a, temp, mid + 1, hi);
		if (a[mid + 1] <= a[mid]) return; // Just an enhancement to reduce computation on partially sorted arrays
		merge(a, temp, lo, hi, mid);

	}

	//This is a setup function. We can do the sort even without this.
	//The auxillary array has to be passed to reduce space complexity.
	public void sort(int[] a) {
		int n = a.length;
		int[] temp = new int[n];
		divide(a, temp, 0, n - 1);
	}


	//Calling main method with inputs.
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
//		System.out.println(p.length);
		MergeSort x = new MergeSort();
		x.sort(p);

		for (int i = 0; i < n; i++) {
			System.out.println(p[i]);
		}
		sc.close();
	}
}

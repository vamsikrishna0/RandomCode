package hr.sorting;

import java.util.Scanner;

public class QuickSortWithSwapCount {

	public static int sort(int[] p, int lo, int hi) {
		if (hi == lo)
			return 0;

		if (lo < hi) {
			int[] part = partition(p, lo, hi);

			int leftSwaps = sort(p, lo, part[1] - 1);
			int rightSwaps = sort(p, part[1] + 1, hi);
			return part[0] + leftSwaps + rightSwaps;
		}
		
		return 0;
	}

	public static int[] partition(int[] p, int lo, int hi) {
		int[] data = new int[2];
		int pivot = p[hi];
		int tmp;
		int i = lo;
		int swaps = 0;
		for (int j = lo; j <= hi - 1; j++) {
			if (p[j] <= pivot) {
				swaps++;
				tmp = p[i];
				p[i] = p[j];
				p[j] = tmp;
				i = i + 1;
			}
		}

		tmp = p[hi];
		p[hi] = p[i];
		p[i] = tmp;

		swaps++;
		data[0] = swaps;
		data[1] = i;
		return data;
	}
	
	public static int insertionSort(int[] p) {
		int tmp, j;
		int swaps = 0;
		for (int i = 1; i < p.length; i++) {
			j = i;
			while (j > 0 && p[j] < p[j-1]) {
				swaps++;
				tmp = p[j];
				p[j] = p[j - 1];
				p[j - 1] = tmp;
				j--;
			}
		}
		return swaps;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		int[] p_IS = new int[n];
		for (int i = 0; i < n; i++) {
			int z = sc.nextInt();;
			p[i] = z;
			p_IS[i] = z;
		}

		int swaps_QS = sort(p, 0, n - 1);
		int swaps_IS = insertionSort(p_IS);
		System.out.println(swaps_IS - swaps_QS);
	}
}

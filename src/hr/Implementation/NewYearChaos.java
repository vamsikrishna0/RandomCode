package hr.Implementation;

import java.util.Scanner;

public class NewYearChaos {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int q[] = new int[n];
			for (int q_i = 0; q_i < n; q_i++) {
				q[q_i] = in.nextInt();
			}
			int count = 0;
			for (int q_i = 0; q_i < n; q_i++) {
				if (q[q_i] > q_i + 3) {
					count = -1;
					break;
				}
			}
			if (count == -1) {
				System.out.println("Too chaotic");
			} else {
				System.out.println(countNumOfBribes(q, 0, n - 1));
			}
		}
	}

	private static int countNumOfBribes(int[] q, int i, int j) {
		//base case
		if (i >= j)
			return 0;
		//implementation
		int mid = (i + j) / 2;
		int left = countNumOfBribes(q, i, mid);
		int right = countNumOfBribes(q, mid + 1, j);
		int cross = countCrossBribes(q, i, mid, j);
		return left + right + cross;
	}

	private static int countCrossBribes(int[] q, int i, int mid, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		int leftStart = i;
		int rightStart = mid + 1;
		int[] temp = new int[j - i + 1];
		int p = 0;
		while (leftStart <= mid && rightStart <= j) {
			if (q[leftStart] < q[rightStart]) {
				temp[p] = q[leftStart];
				p++;
				leftStart++;
			} else {
				temp[p] = q[rightStart];
				count += mid - leftStart + 1;//Count the number of inversions
				p++;
				rightStart++;
			}
		}
		//Copy remaining elements into the temp
		if (leftStart > mid) {
			while (rightStart <= j) {
				temp[p] = q[rightStart];
				p++;
				rightStart++;
			}
		} else if (rightStart > j) {
			while (leftStart <= mid) {
				temp[p] = q[leftStart];
				p++;
				leftStart++;
			}
		}
		//Copy back into the array
		for (int z = 0; z < temp.length; z++) {
			q[i] = temp[z];
			i++;
		}
		return count;
	}
}

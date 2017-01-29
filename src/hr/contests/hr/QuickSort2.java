package hr.contests.hr;

import java.util.Scanner;

public class QuickSort2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar, 0, ar.length-1);
		printArray(ar);
		in.close();

	}

	static void partition(int[] ar, int start, int end) {
		if(end - start <= 0){
			printArray(ar);
			return;
		}else{
			int p = ar[start];
			int left = start;
			int right = end;
			
			while(left - right > 0){
				if(ar[right] < p){
					ar[left] = ar[right];
					left++;
					ar[right] = ar[left];
				}else{
					right--;
				}
			}
			ar[left] = p;
			
			partition(ar, start, left-1);
			printArray(ar);
			partition(ar, right+1, end);
			return;
		}
		
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	

}

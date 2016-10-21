package hr.hr;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort1 {

	static void partition(int[] ar) {
		int p = ar[0];
		int len = ar.length;
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for(int i=1 ; i<len; i++){
			if(ar[i] < p){
				left.add(ar[i]);
			}else{
				right.add(ar[i]);
			}
		}
		
		ArrayList<Integer> full = new ArrayList<>();
		full.addAll(left);
		full.add(p);
		full.addAll(right);
		int[] list = new int[full.size()];
		int j = 0;
		for(Integer x : full){
			
			list[j] = x;
			j++;
		}		
		printArray(list);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
 
		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}


}

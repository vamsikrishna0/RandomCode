package hr.Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class SparseArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> stringFreq = new HashMap<>();
		for(int i=0; i<n; i++){
			String x = in.next();
			if(stringFreq.containsKey(x)){
				stringFreq.put(x, stringFreq.get(x)+1);
			}else{
				stringFreq.put(x, 1);
			}
		}
		
		int q = in.nextInt();
		for(int i=0; i<q; i++){
			String queryString = in.next();
			if(stringFreq.containsKey(queryString))
			    System.out.println(stringFreq.get(queryString));
			else
				System.out.println("0");
		}
	}
}

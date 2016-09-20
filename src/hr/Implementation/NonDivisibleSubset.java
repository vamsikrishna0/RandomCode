package hr.Implementation;

import java.util.HashMap;
import java.util.Scanner;

/* Learnings:
 * The use of reminders(mods) for computing divisibility of sums of numbers.
 * 
 * */
public class NonDivisibleSubset {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int sizeOfMaximalSubset = 0;
		HashMap<Integer, Integer> remainders = new HashMap<>();
		long c;
		int modc;
		for (int i = 0; i < n; i++) {
			c = in.nextLong();
			modc = (int) (c % k);
			if (remainders.containsKey(modc)) {
				remainders.put(modc, remainders.get(modc) + 1);
			} else
				remainders.put(modc, 1);
		}
		
		for(int x: remainders.keySet()){
			if(x == 0)
				sizeOfMaximalSubset++;
			else if (x == k-x)
				sizeOfMaximalSubset++;
			else{
				if(remainders.containsKey(k-x)){
					if(remainders.get(x) > remainders.get(k-x))
						sizeOfMaximalSubset += remainders.get(x);
					else if (remainders.get(x) == remainders.get(k-x)){
						sizeOfMaximalSubset += remainders.get(x);
						remainders.put(x, 0);
						remainders.put(k-x, 0);
					}
				}else{
					sizeOfMaximalSubset += remainders.get(x);
				}
			}			
		}
		System.out.println(sizeOfMaximalSubset);
	}
}

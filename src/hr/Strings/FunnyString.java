package hr.Strings;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FunnyString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			List<Integer> asciiValues = str.chars().mapToObj(e -> (int) e).collect(Collectors.toList());
			int len = asciiValues.size();
			boolean x = true;
			for (int j = 1; j < len; j++) {
				if(Math.abs(asciiValues.get(j) - asciiValues.get(j-1)) 
						!= Math.abs(asciiValues.get(len-1-j) - asciiValues.get(len-j))){
					x = false;
					break;
				}
			}
			if(x) System.out.println("Funny");
			else System.out.println("Not Funny");
		}
		sc.close();
	}
}

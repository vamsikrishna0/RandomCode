package hr.Strings;

import java.util.Scanner;

public class AlternatingCharacters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			//Regex to match a particular character, here "A", is that itself. "A+" checks for occurrences of consecutive A's
			System.out.println(str.length() - str.replaceAll("A+", "A").replaceAll("B+","B").length());
			
		}
		sc.close();
	}
}

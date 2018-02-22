package hr.Strings;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Gemstones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		Set<Character> x = str.chars().distinct().mapToObj(e -> (char) e).collect(Collectors.toSet());
		for (int i = 1; i < n; i++) {
			str = sc.next();
			Set<Character> w = str.chars().distinct().mapToObj(e -> (char) e).collect(Collectors.toSet());
			x.retainAll(w);
		}
		System.out.println(x.size());
		sc.close();
	}
}

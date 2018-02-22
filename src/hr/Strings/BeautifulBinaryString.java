package hr.Strings;

import java.util.Scanner;

public class BeautifulBinaryString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		String str = sc.next();
		System.out.println((str.length() - str.replaceAll("010", "").length())/3);
		sc.close();
	}
}

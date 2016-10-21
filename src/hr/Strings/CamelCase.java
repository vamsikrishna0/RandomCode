package hr.Strings;

import java.util.Scanner;

public class CamelCase {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
			if(Character.isUpperCase(chars[i]))
				count++;
		}
        System.out.println(++count);
        in.close();
	}
}

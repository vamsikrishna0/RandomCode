package hr.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TwoCharacters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        ArrayList<Integer> lenOfStr = new ArrayList<>();
		List<Character> letters =  s.chars().distinct().mapToObj(e -> (char) e).collect(Collectors.toList());

		if(letters.size() == 1){
			System.out.println("0");
		}else{
			for (int i = 0; i < letters.size(); i++) {
				for (int j = i+1; j < letters.size(); j++) {
					int tmp = keepChars(s, letters.get(i), letters.get(j));
					lenOfStr.add(tmp);
				}
			}
			
			OptionalInt xyz = lenOfStr.stream().mapToInt(e -> e).max();
			System.out.println(xyz.getAsInt());
		}
		in.close();
	}
	public static int keepChars(String inputStr, char ch1, char ch2){
		char[] w = inputStr.toCharArray();
		StringBuilder x = new StringBuilder();
		for (int i = 0; i < inputStr.length(); i++) {
			if(w[i] == ch1 || w[i] == ch2){
				x.append(w[i]);
			}
		}
		int len = x.length();
		if (len <= 1)
			return 0;
		
		char last = x.charAt(0);
		for (int i = 1; i < len; i++) {
			if(x.charAt(i) == last)
				return 0;
			last = x.charAt(i);
		}
		return len;
	}
}

package hr.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pangrams {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		ArrayList<String> sentenceArray = new ArrayList<>();
		sentenceArray.addAll(Arrays.asList(sentence.toLowerCase().split("")));
		String[] alphabetArray = alphabet.split("");
		boolean result = sentenceArray.containsAll(Arrays.asList(alphabetArray));
		
		if(result)
			System.out.println("pangram");
		else
			System.out.println("not pangram");
		sc.close();
	}

}

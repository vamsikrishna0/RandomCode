package interview;

import java.util.Scanner;

public class CountPalindromes {
	static int count_palindromes(String s){
		int size = s.length();
		int len = size;
		StringBuilder x = new StringBuilder(s);
		int count=0;
		while(size >0){
			for(int i=0; i <= len-size; i++){
				
				if(isPalindrome(x.substring(i, i+size)))
					count++;
			}
			size--;
		}
		return count;
	}
	static boolean isPalindrome(String s){
		int i=0;
		int j = s.length()-1;
		while(i<=j){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
				
			}else{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(count_palindromes(str));
		sc.close();
	}
}

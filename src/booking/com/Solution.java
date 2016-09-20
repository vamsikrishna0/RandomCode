package booking.com;

import java.util.*;

//1465948800
//
//1468540800
public class Solution {

	public static void main(String[] args) {

	}

	static int palindrome(String str) {
		Set<String> substrings = new HashSet<>();
		int len = str.length();
		char[] x = str.toCharArray();
		for(int i = 1; i<=len; i++){
			for(int j=0; j<= len-i; j++){
				//j to j+i-1
				int start=j, end=j+i-1;
				while(start < end){
					if(x[start] != x[end]){
						break;
					}
					start++;
					end--;
				}
				if(start >= end){
					substrings.add(str.substring(j, j+i));
				}
				
			}
			
		}
		return substrings.size();
	}
}
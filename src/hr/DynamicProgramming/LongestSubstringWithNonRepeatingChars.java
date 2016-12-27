package hr.DynamicProgramming;

import java.util.HashSet;

public class LongestSubstringWithNonRepeatingChars {
    public int longestNonRepeating(String str){
        int len = str.length();
        HashSet<Character> seen = new HashSet<>();
        int curr_len = 0;
        int start_index = 0;
        int end_index = 0;
        int max_len = 0;

        for (int i = 0; i < len; i++) {
            if(!seen.contains(str.charAt(i))){
                curr_len++;
                seen.add(str.charAt(i));
            }else{
                end_index = i-1;
                max_len = curr_len;
            }
        }
        return 0;
    }
}

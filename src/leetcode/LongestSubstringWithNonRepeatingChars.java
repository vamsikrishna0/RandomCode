package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithNonRepeatingChars {
    //Given a string find the longest substring with non repeating characters

    /*  A two pointer problem approach or Sliding window approach

        This is a canonical substring problem.

        Used when there is an array and a property of a sub array is to be found.
        Here maxLength is updated for each new char
        Hence, A DP solution*/
    public int longestNonRepeating(String s) {
        if (s == null || s.isEmpty()) return 0;
        int maxLength = 0;
        int start = 0;

        HashMap<Character, Integer> seen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //If the char is already seen and last seen instance of c is after start
            //update start to the next index of c.
            if (seen.containsKey(c) && seen.get(c) >= start) {
                start = seen.get(c) + 1;
            }

            //Put the updated version of c and its index, i.e the last seen instance is this one
            seen.put(c, i);

            //Update maxLength, after checking if the word(with non-repeating characters) ending with the letter at the present index,
            // has length(current_index - start +1) greater than maxLength.
            //TLDR: update the maxLength field for substring from index, 0 to i.
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}

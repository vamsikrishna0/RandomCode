package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithNonRepeatingChars {
    //Given a string find the longest substring with non repeating characters

    /*  A two pointer problem approach or Sliding window approach

        This is a canonical substring problem

        Used when there is an array and a property of a sub array is to be found.
        Here maxLength is updated for each new char */
    public int longestNonRepeating(String s) {
        if (s.isEmpty() || s == null) return 0;
        int maxLength = 0;
        int start = 0;

        HashMap<Character, Integer> seen = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //If the char is already seen and last seen instance of c is after start
            //update start to the next index of c.
            if (seen.containsKey(c) && seen.get(c) >= start) {
                start = seen.get(c) + 1;
            }

            //Put the updated version of c and its index, i.e the last seen instance is this one
            seen.put(c, i);

            //Update maxLength to check if current word's max length(current_index - start +1) is greater and then set it.
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}

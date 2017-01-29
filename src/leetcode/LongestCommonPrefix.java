package leetcode;

/**
 * Created by Vamsi on 12/31/2016.
 */
public class LongestCommonPrefix {
    //Longest common prefix for an array of strings
    public static void main(String[] args) {
        LongestCommonPrefix x = new LongestCommonPrefix();
        String[] str = new String[2];
        str[0] = "aabcd";
        str[1] = "aabcd";
        System.out.println(x.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength)
                minLength = str.length();
        }
        while (i < minLength && strs.length > 0) {
            char first = strs[0].charAt(i);
            for (String x : strs) {
                if (first != x.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        if (strs.length > 0)
            return strs[0].substring(0, minLength);
        else
            return "";
    }
}

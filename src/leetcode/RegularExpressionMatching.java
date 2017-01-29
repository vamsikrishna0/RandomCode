package leetcode;

/**
 * Created by Vamsi on 12/29/2016.
 */
public class RegularExpressionMatching {
    //Given a string and a regular expression, see if they match
    public static void main(String[] args) {
        RegularExpressionMatching x = new RegularExpressionMatching();

        System.out.println(x.isMatch("aa", "a"));
        System.out.println(x.isMatch("aa", "aa"));
        System.out.println(x.isMatch("aaa", "aa"));
        System.out.println(x.isMatch("aa", "a*"));
        System.out.println(x.isMatch("aa", ".*"));
        System.out.println(x.isMatch("ab", ".*"));
        System.out.println(x.isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {

        //Basically uses backtracking

        /* Recursion, backtracking, enumerating partial solutions
           1. Check for all base cases where u can reject a result, (return false)
           2. Check for cases where u can accept
           3. Find other partial solutions and check the set of possible solutions:
           4. Recur on each partial solution assuming an added part of the problem solved.
           5. Return once a solution is found, back until the root of the recursion stack.
        * */


        //Pattern is empty string. Return true if string is empty, else false
        if (p.isEmpty())
            return (s.isEmpty());

        //Take first char of pattern
        char t = p.charAt(0);
        //length is 1 means the pattern is either a '.' or an absolute character match. All other cases its false
        if (p.length() == 1) {
            return (s.length() == 1) && (t == '.' || (s.charAt(0) == t));
        }

        if (p.charAt(1) != '*') {
            return !s.isEmpty() && !(t != '.' && s.charAt(0) != t) && (isMatch(s.substring(1), p.substring(1)));

        } else {
            //maxLength is last index of the string matching this(first char followed by a '*') particular regex token
            int maxLength = 0;
            if (t == '.')
                maxLength = s.length();
            else {
                while (maxLength < s.length() && s.charAt(maxLength) == t) {
                    maxLength++;
                }
            }

            //removing this token and recursing on every probable substring, starting from the largest matched to least
            String subp = p.substring(2);//sub pattern after removing the first token
            for (int i = maxLength; i >= 0; i--) {
                if (isMatch(s.substring(i), subp)) //recurse by removing every substring that matched from the original string
                    return true;
            }
            /*A concise code of the previous block

            int len = s.length();

            int i = -1;
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }*/
            return false;
        }

    }
}

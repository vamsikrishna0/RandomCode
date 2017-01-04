package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring x = new LongestPalindromicSubstring();
        System.out.println(x.longestPalindrome("kyyrjtdplseovzwjkykrjwhxquwxsfs" +
                "orjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjh" +
                "onlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesiv" +
                "ajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfoj" +
                "euzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfo" +
                "jnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksq" +
                "mzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvj" +
                "qzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqp" +
                "gecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsv" +
                "awkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnm" +
                "qvpwoisniv"));

    }

    //Uses constant space. Key Idea: There are 2n-1 centers. Check for longest palindrome from each. O(n^2)
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public String longestPalindromeDP(String s) {
        int len = s.length();
        String lp = ""+s.charAt(0);
        int lengthOfLp = 1;
        boolean[][] p = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            p[i][i] = true;
            if(i < len-1){
                p[i][i+1] = (s.charAt(i) == s.charAt(i+1));
                if(s.charAt(i) == s.charAt(i+1)){
                    lengthOfLp = 2;
                    lp = s.substring(i, i+2);
                }
            }
        }

        for (int i = 3; i <= len; i++) {
            for (int j = 0; j <= len-i ; j++) {
                int k = j+i-1;
                String sub = s.substring(j, k+1);
                if(p[j+1][k-1] && s.charAt(j)==s.charAt(k)){
                    p[j][k] = true;
                    if(i > lengthOfLp){
                        lengthOfLp = i;
                        lp = sub;
                    }
                }
            }
        }
        return lp;
    }

    boolean isPalindrome(String x) {
        int len = x.length();
        for (int i = 0; i < x.length() / 2; i++) {
            if (!(x.charAt(i) == x.charAt(len - i - 1)))
                return false;
        }
        return true;
    }
}

package hr.DynamicProgramming;

/**
 * Created by Vamsi on 12/24/2016.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(LCS("ABCDGH", "AEDFHR"));

    }

    // Bottom-up version
    public static int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] lenSubstring = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lenSubstring[i][j] = 1+lenSubstring[i-1][j-1];
                } else {
                    if (lenSubstring[i - 1][j] > lenSubstring[i][j - 1])
                        lenSubstring[i][j] = lenSubstring[i-1][j];
                    else
                        lenSubstring[i][j] = lenSubstring[i][j-1];
                }
            }
        }
        /* For testing purposes
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(lenSubstring[i][j]+" ");
            }
            System.out.println();
        }*/
        return lenSubstring[len1][len2];
    }
}

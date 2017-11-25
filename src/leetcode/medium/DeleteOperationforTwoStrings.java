package leetcode.medium;

/**
 * Created by Vamsi on 7/17/2017.
 */
public class DeleteOperationforTwoStrings {
    public static void main(String[] args) {
        DeleteOperationforTwoStrings x = new DeleteOperationforTwoStrings();
        System.out.println(x.minDistance("sea", "eat"));
    }
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * (LCS(word1, word2));
    }
    public static int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        //Creating the sub problem solution matrix. first row and first column are 0's
        int[][] lenSubstring = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //When characters are equal
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    //Add 1 to the result of sub problem of strings until (i-1) and (j-1). i.e substrings before these elements
                    lenSubstring[i][j] = 1 + lenSubstring[i - 1][j - 1];

                } else {
                    lenSubstring[i][j] = Math.max(lenSubstring[i][j - 1], lenSubstring[i - 1][j]);
                }
            }
        }
        return lenSubstring[len1][len2];
    }
}

package hr.DynamicProgramming;

/**
 * Created by Vamsi on 12/24/2016.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(LCS("ABCDGH", "AEDFHR"));

    }

    // Bottom-up version: DP solution
    //O(n) time and O(n) space
    public static int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        //Creating the sub problem solution matrix. first row and first column are 0's
        int[][] lenSubstring = new int[len1 + 1][len2 + 1];

        //Start from first row to last, while filling up each cell from left to right. Coz for solving this sub problem(i, j),
        //we only need diagonally top(i-1, j-1), left(i-1, j) and right(i, j-1)

        //PS: The order is important. Its the Topological order of sub problem dependency graph.
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //When characters are equal
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    //Add 1 to the result of sub problem of strings until (i-1) and (j-1). i.e substrings before these elements
                    lenSubstring[i][j] = 1 + lenSubstring[i - 1][j - 1];

                } else {
                    //When characters are not equal
                    //Set the subproblem's solution to be, max of results of subproblems involving only one of the present chars
                    // i.e max of [i][j - 1], and [i-1][j]
                    lenSubstring[i][j] = Math.max(lenSubstring[i][j - 1], lenSubstring[i - 1][j]);
                }
            }
        }
        /* Print the matrix: For testing purposes
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(lenSubstring[i][j]+" ");
            }
            System.out.println();
        }*/
        return lenSubstring[len1][len2];
    }
}

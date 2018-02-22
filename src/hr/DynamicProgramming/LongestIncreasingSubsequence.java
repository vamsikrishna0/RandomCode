package hr.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by Vamsi on 12/24/2016.
 */
public class LongestIncreasingSubsequence {
    //Fing the length of Longest Increasing Subsequence(means the chars need not be contiguous)
    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        System.out.println(LIS(arr));;

        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            int len = sc.nextInt();
            int[] seq = new int[len];
            for (int j = 0; j < len; j++) {
                seq[j] = sc.nextInt();
            }
            System.out.println(LIS(seq));;
        }
    }

    //Bottom-up version: DP Solution
    //O(n^2) time O(n) space
    public static int LIS(int[] seq){
        int n = seq.length;
        //The array that memorizes the result for subproblems i.e max length of, subsequences of string, from i to last
        int[] lengthOfSubsequence = new int[n];

        //Iterating from last to first
        for (int i = n-1; i >= 0 ; i--) {
            lengthOfSubsequence[i] = 1;

            //Find max of those subproblem results, with an increasing number
            int temp = 0;
            for (int j = i+1; j < n ; j++) {
                if (seq[j] > seq[i] && lengthOfSubsequence[j] > temp)
                    temp = lengthOfSubsequence[j];
            }

            lengthOfSubsequence[i] += temp;
        }
        return lengthOfSubsequence[0];
    }
}

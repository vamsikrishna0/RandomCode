package leetcode.easy;

/**
 * Created by Vamsi on 5/9/2017.
 */
public class MaximumSubarray {
    //The idea is to find the max sum of the subarray, not the subarray itself.

    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i], 0);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}

package leetcode.HashTable;

import java.util.HashMap;

/**
 * Created by Vamsi on 6/4/2017.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> abmap = new HashMap<>(A.length);
        int res = 0;
        for (int aA : A) {
            for (int aB : B) {
                abmap.put(aA + aB, abmap.getOrDefault(aA + aB, 0) + 1);
            }
        }

        for (int aC : C) {
            for (int aD : D) {
                res += abmap.getOrDefault(-1 * (aC + aD), 0);
            }
        }
        return res;
    }
}

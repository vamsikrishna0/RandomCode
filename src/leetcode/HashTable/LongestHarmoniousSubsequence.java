package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (int key :freq.keySet()) {
            if(freq.containsKey(key + 1)) {
                int p = (freq.getOrDefault(key, 0) + freq.getOrDefault(key + 1, 0));
                if (max < p)
                    max = p;
            }
        }
        return max;
    }
}

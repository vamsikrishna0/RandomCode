package leetcode.HashTable;

import java.util.*;

/**
 * Created by Vamsi on 5/30/2017.
 *
 * **Easy
 */
public class ContainsDuplicateII {

    //O(1) in space (only k spaces needed)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> setofinterest = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i > k)
                setofinterest.remove(nums[i-k-1]);
            if(!setofinterest.add(nums[i]))
                return true;
        }
        return false;
    }

    //O(n) in space
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> mapofindices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapofindices.containsKey(nums[i])) {
                if (i - mapofindices.get(nums[i]) <= k) {
                    return true;
                }
            }
            mapofindices.put(nums[i], i);
        }
        return false;
    }
}

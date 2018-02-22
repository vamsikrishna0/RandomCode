package leetcode.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if(!set.add(i)) return true;
        }
        return false;
    }
}

package leetcode.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1set = new HashSet<>();
        Set<Integer> num2set = new HashSet<>();
        for (int n:nums1) {
            num1set.add(n);
        }
        for (int n: nums2) {
            if(num1set.contains(n))
            num2set.add(n);
        }
        int[] result = new int[num2set.size()];
        int i = 0;
        for (Integer num : num2set) {
            result[i++] = num;
        }
        return result;
    }
}

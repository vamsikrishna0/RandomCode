package leetcode.HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vamsi on 5/30/2017.
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums1){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i: nums2){
            if(freq.getOrDefault(i, 0) != 0){
                res.add(i);
                freq.put(i, freq.get(i) - 1);
            }
        }
        return  res.stream().mapToInt(i -> i).toArray();
    }
}

package leetcode.easy;

import java.util.HashMap;

/**
 * Created by Vamsi on 12/27/2016.
 */
public class TwoSum {

    //Given an array find the indices of the two numbers which sum up to the 'target'

    public static void main(String[] args) {
        TwoSum x = new TwoSum();
        int[] arr = {3,2,4};
        int target = 6;
        System.out.println(x.twoSum(arr, target)[0]);
    }
    /**
     *Approach1:
     *Add the index of an element into hashtable, while its complement doesn't exist
     * if complement found return indices of both.(number and its complement)
     * O(n) extra space for O(n) time
     *
     * Approach2:
     * Sort and then use two pointer approach
     * O(1) extra space for O(nlogn) time
     */
    public int[] twoSum(int[] nums, int target) {
        int j = nums.length;

        //Hashtable keeps track of the occurrence of each number and breaks and returns when the complement of a given number is found.
        //Just one pass through the data.

        //Hashmap contains value --> indices mapping. O(n) extra space for O(n) time
        HashMap<Integer, Integer> mapToIndices= new HashMap<>();
        for (int k = 0; k < j; k++) {
            if(mapToIndices.containsKey(target-nums[k])){
                int[] result = {mapToIndices.get(target-nums[k]), k};
                return result;
            }
            mapToIndices.put(nums[k], k);
        }
        return null;
    }
}

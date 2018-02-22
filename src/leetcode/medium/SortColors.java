package leetcode.medium;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        for(int i=0; i<3 ; i++){
            int p = freq.getOrDefault(i, 0);
            while(p > 0){
                nums[k] = i;
                k++;
                p--;
            }
        }
    }

    //Using 3 pointer approach
    public void sortColors2(int[] nums) {
        int i=0, j = 0, k = nums.length -1;

        while(i <= k && i < nums.length && k >= 0){
            if(nums[i] == 0){
                swap(nums, i, j);
                j++;
            }
            if(nums[i] == 2){
                swap(nums, i, k);
                k--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i,int  j){
        int p = nums[i];
        nums[i] = nums[j];
        nums[j] = p;
    }
}

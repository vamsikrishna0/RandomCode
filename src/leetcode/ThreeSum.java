package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //Given an array find all non-repeated trio of numbers which sum up to 0.
    public static void main(String[] args) {
        ThreeSum x = new ThreeSum();
        int[] arr = {-1, 0, 1, 2, -1, -4};

    }

    //A O(n^2) algo. Which checks for every pair to see if the sum is 0;
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length<3)
            return res;

        Arrays.sort(nums);
        int a, b, c;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {

            //Handles repeated elements:
            // If a previous element was part of the trio, the next equal element is also part of it.
            // Coz in a sorted array equal elements occur next to each other
            if (i == 0 || nums[i] > nums[i - 1]) {
                a = nums[i];
                int left = i + 1, right = len - 1;
                while (left < right) {
                    b = nums[left];
                    c = nums[right];
                    int sum = a + b + c;
                    if (sum == 0) {
                        ArrayList<Integer> x = new ArrayList<>();
                        x.add(a);
                        x.add(b);
                        x.add(c);
                        res.add(x);
                        left++;
                        right--;

                        //handle duplicate here
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

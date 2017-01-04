package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length<3)
            return res;

        Arrays.sort(nums);
        int a, b, c, d;
        int len = nums.length;
        for (int j = 0; j < len - 3; j++) {
            if (j == 0 || nums[j] > nums[j - 1]) {
                a = nums[j];
                for (int i = j + 1; i < len - 2; i++) {

                    //Handles repeated elements:
                    // If a previous element was part of the trio, the next equal element is also part of it.
                    // Coz in a sorted array equal elements occur next to each other
                    if (i == j+1 || nums[i] > nums[i - 1]) {
                        b = nums[i];
                        int left = i + 1, right = len - 1;
                        while (left < right) {
                            c = nums[left];
                            d = nums[right];
                            int sum = a + b + c + d;
                            int diff = sum - target;
                            if (diff == 0) {
                                ArrayList<Integer> x = new ArrayList<>();
                                x.add(a);
                                x.add(b);
                                x.add(c);
                                x.add(d);
                                res.add(x);
                                left++;
                                right--;

                                //handle duplicate here
                                while (left < right && nums[left] == nums[left - 1])
                                    left++;
                                while (left < right && nums[right] == nums[right + 1])
                                    right--;
                            } else if (diff < 0) {
                                left++;
                            } else if (diff > 0) {
                                right--;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest x = new ThreeSumClosest();
        int[] arr ={0,2,1,-3};
        System.out.println(x.threeSumClosest(arr, 1));
    }
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3)
            return 0;

        int minSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
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
                    int diff = sum - target;
                    System.out.println(sum+" "+ diff);
                    if(Math.abs(diff) < minDiff){
                        minDiff = Math.abs(diff);
                        minSum = sum;
                    }
                    if (diff == 0) {

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
        return minSum;
    }
}

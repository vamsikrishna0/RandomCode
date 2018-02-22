package leetcode.medium;

/**
 * Created by Vamsi on 1/25/2017.
 */
public class NextPermutation {
    //31. Next Permutation
    //linear time, constant space
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int i = nums.length - 1, j = 0, k = i;
        while (i > 0) {
            if (nums[i - 1] < nums[i]) { // Find the first index(i) where, when going from right to left, we get a decreasing predecessor
                int temp = nums[i - 1];
                while (nums[k] <= temp) k--; // Find the highest from right that is greater than value at(i-1), i.e the next highest value

                //swap values from kth position and i-1 th
                nums[i - 1] = nums[k];
                nums[k] = temp;

                j = i;
                break;
            }
            i--;
        }
        // Reverse all the elements from i to the end.(to create te least suffix)
        reverseArray(nums, j);
    }
    void reverseArray(int[] nums, int j){
        int k = nums.length;
        while (j < k) {
            if (nums[j] != nums[k]) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
            }
            j++;
            k--;
        }
    }
}

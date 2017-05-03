package leetcode.easy;

import java.util.Arrays;

/**
 * Created by Vamsi on 4/26/2017.
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        ArrayPartitionI x = new ArrayPartitionI();
        int[] num = {1, 4, 3, 2, 6, 5};
        System.out.println(x.arrayPairSum(num));
    }
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

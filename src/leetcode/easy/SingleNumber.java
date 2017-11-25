package leetcode.easy;

/**
 * Created by Vamsi on 5/22/2017.
 */
public class SingleNumber {
    //a^a = 0.. So xor all the nums of the array, which leaves only the non repeated number.
    public int singleNumber(int[] nums) {
        for(int i=1; i<nums.length; i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}

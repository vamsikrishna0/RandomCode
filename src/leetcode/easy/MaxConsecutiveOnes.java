package leetcode.easy;

/**
 * Created by Vamsi on 1/21/2017.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1)
            return nums[0]; //
        int count = 0;
        for(int i=1; i<len; i++){
            if(nums[i] == 1 && nums[i-1] == 1){
                count++;
            }else if(nums[i] == 0 && nums[i-1] == 1){
                if(max < ++count){
                    max = count;
                }
                count = 0;
            }
        }
        StringBuilder sb = new StringBuilder("dskjd");
        if(nums[len-1] == 1){
            if(max < ++count)
                max = count;
        }
        return max;

        /*
        *
        //A more concise solution, which doesn't require comparing previous elements
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
        */
    }
}

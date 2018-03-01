package leetcode.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0, j=0;
        int temp;
        while(j < nums.length){
            if(nums[j] != 0){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }

    }
}

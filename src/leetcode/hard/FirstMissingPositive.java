package leetcode.hard;

/**
 * Created by Vamsi on 1/28/2017.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive x = new FirstMissingPositive();
        int[] ww = {3,4,-1,1};
        System.out.println(x.firstMissingPositive(ww));
    }
    //41. First Missing Positive

    /*
    *
    * Approach 1:
    * The key idea here is that the first missing positive number is between 1 and n+1 inclusive. where n is the number of positive numbers.
    * The algo is to swap positive numbers, which are less than n, to the index which is same as the value. i.e nums[8] -> 7th index
    * */
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int len = nums.length;
        int i = 0, j = len-1;
        while (i<=j){
            if(nums[i] > 0)
                i++;
            else{
                swap(nums, i, j);
                j--;
            }
        }
        int k = j + 1;
        while(i < len){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > k+1) i++;
            else if(nums[nums[i] -1] != nums[i]) swap(nums, nums[i]-1, i);
            else i++;
        }
        i = 0;
        while(i < len && nums[i] == i+1) i++;
        return i+1;
    }
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}

package leetcode.easy;

/**
 * Created by Vamsi on 1/28/2017.
 */
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber x = new MissingNumber();
        int[] ww = {0, 1, 3, 4, 5, 6, 2, 8};
        System.out.println(x.missingNumber(ww));
    }
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int len = nums.length;
        int i = 0;
        while(i<len){
            if (nums[i] < len && nums[i] != i) {
                swap(nums, nums[i], i);
            }else{
                i++;
            }
        }

        //As overall algo is O(n), this is a small optimization. Use binary search to find the missing element.
        // i.e, if(nums[i] == i)
        //          go right;
        //      else go left;
        int j = 0;
        for (int k = 0; k < len; k++) {
            if (nums[k] != k)
                break;
            else j++;
        }
        return j;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        int n = nums.length;
        sum = ((n+1) * n) / 2;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}

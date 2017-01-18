package leetcode;

/**
 * Created by Vamsi on 1/6/2017.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray x = new RemoveDuplicatesFromSortedArray();
        int[] w = {1, 1, 1};
//        System.out.println(x.removeDuplicates(w));
        for (int i = 0; i < 5; ++i) {
            System.out.println(i);
        }
    }

    public int removeDuplicates(int[] nums) {
        int j=1;
        int len = nums.length;
        int res = len;
        for (int i = 0; i < len-1; i++) {
            if(nums[i] != nums[i+1]){
                nums[j] = nums[i+1];
                j++;
            }else
                res--;
        }
        return res;
    }
}

package leetcode.easy;

/**
 * Created by Vamsi on 1/24/2017.
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement x = new RemoveElement();
        int[] ww = {3,3};
        x.removeElement(ww, 3);
        for (int p:
             ww) {
            System.out.println(p);
        }
    }
    //27
    public int removeElement(int[] nums, int val) {
        int num = 0;

        int i=0, j = nums.length-1;
        while(i<j && nums[i] != val){
            i++;
        }
        while(j>=0 && nums[j] == val){
            num++;
            j--;
        }
        //2 pointer approach
        while(i<j){
            nums[i] = nums[j];
            j--;
            num++;
            while(nums[i] != val) i++;
            while(j>=0 && nums[j] == val){
                num++;
                j--;
            }
        }
        return nums.length - num;
    }
}

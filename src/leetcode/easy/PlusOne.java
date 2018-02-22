package leetcode.easy;

/**
 * Created by Vamsi on 5/20/2017.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}

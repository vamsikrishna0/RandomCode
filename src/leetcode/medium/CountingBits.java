package leetcode.medium;

/**
 * Created by Vamsi on 1/21/2017.
 */
public class CountingBits {
    //Classic case of DP.
    public int[] countBits(int num) {
        if(num < 0)
            return null;
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0)
            return res;
        int exponent = 1;
        for(int i=1; i<=num; i++){
            //updating tick and exponent
            if(i == exponent * 2){
                exponent *= 2;;
            }
            res[i] = res[i - exponent] + 1; // DP step.
        }
        return res;
    }
}

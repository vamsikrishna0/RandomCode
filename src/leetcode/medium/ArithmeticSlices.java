package leetcode.medium;

/**
 * Created by Vamsi on 1/21/2017.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int res = 0;
        int len = A.length;
        int diff = 0;
        for(int i=0; i<len-2; i++){
            if((A[i+1] - A[i]) == (A[i+2] - A[i+1])){
                diff = A[i+1] - A[i];
                res++;
                for(int j = i+3; j<len; j++){
                    if(diff == (A[j]- A[j-1]))
                        res++;
                    else
                        break;
                }
            }
        }
        return res;

        /*

        //A clearer implemetation
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
            curr += 1;
            sum += curr;
        } else {
            curr = 0;
        }
        return sum;

        * */
    }
}

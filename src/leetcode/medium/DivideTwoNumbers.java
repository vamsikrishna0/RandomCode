package leetcode.medium;

/**
 * Created by Vamsi on 1/25/2017.
 */
public class DivideTwoNumbers {
    /*
    * Incomplete
    * */
//    public int divide(int dividend, int divisor) {
//        int q = 0;
//        final int Mone = -1;
//        final int Pone = 1;
//        if (divisor == 0) // division not defined
//            return Integer.MAX_VALUE;
//        if (dividend == 0)
//            return 0;
//
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == -1)
//                return Integer.MAX_VALUE;
//            if (divisor == Integer.MIN_VALUE)
//                return 1;
//        }
//        if (divisor == 1)
//            return dividend;
//        if (divisor == -1)
//            return -dividend;
//        if (divisor == Integer.MIN_VALUE)
//            return 0;
//        if (dividend < 0) {
//            if (divisor < 0) {
//                if (dividend == Integer.MIN_VALUE) {
//                    dividend -= divisor;
//                    q++;
//                }
//                return divideHelper(Math.abs(dividend), Math.abs(divisor), q);
//            } else {
//                if (dividend == Integer.MIN_VALUE) {
//                    dividend += divisor;
//                    q++;
//                }
//                return -1 * divideHelper(Math.abs(dividend), divisor, q);
//            }
//        } else if (divisor < 0) {
//            return -1 * divideHelper(dividend, Math.abs(divisor), q);
//        }
//        return divideHelper(dividend, divisor, q);
//    }
//
//    int divideHelper(int dividend, int divisor, int q) {
//        int denom = divisor;
//        int cur = 1;
//        int res = 0;
//        while (denom <= dividend) {
//            cur = cur << 1;
//            denom = denom << 1;
//        }
////Align both msb 1s
//        cur = cur >> 1;
//        denom = denom >> 1;
//        while (cur != 0) {
//            if (denom - dividend >= 0) {
//                res = res | 1;
//                dividend = denom - dividend;
//                dividend = dividend << 1;
//                res = res << 1;
//            }
//            cur = cur >> 1;
//        }
//        q = q + res;
//        return q;
//    }


    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care of the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}

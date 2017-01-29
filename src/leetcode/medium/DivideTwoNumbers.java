package leetcode.medium;

/**
 * Created by Vamsi on 1/25/2017.
 */
public class DivideTwoNumbers {
    /*
    * Incomplete
    * */
    public int divide(int dividend, int divisor) {
        int q = 0;
        final int Mone = -1;
        final int Pone = 1;
        if (divisor == 0) // division not defined
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            if (divisor == Integer.MIN_VALUE)
                return 1;
        }
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return -dividend;
        if (divisor == Integer.MIN_VALUE)
            return 0;
        if (dividend < 0) {
            if (divisor < 0) {
                if (dividend == Integer.MIN_VALUE) {
                    dividend -= divisor;
                    q++;
                }
                return divideHelper(Math.abs(dividend), Math.abs(divisor), q);
            } else {
                if (dividend == Integer.MIN_VALUE) {
                    dividend += divisor;
                    q++;
                }
                return -1 * divideHelper(Math.abs(dividend), divisor, q);
            }
        } else if (divisor < 0) {
            return -1 * divideHelper(dividend, Math.abs(divisor), q);
        }
        return divideHelper(dividend, divisor, q);
    }

    int divideHelper(int dividend, int divisor, int q) {
        int denom = divisor;
        int cur = 1;
        int res = 0;
        while (denom <= dividend) {
            cur = cur << 1;
            denom = denom << 1;
        }
//Align both msb 1s
        cur = cur >> 1;
        denom = denom >> 1;
        while (cur != 0) {
            if (denom - dividend >= 0) {
                res = res | 1;
                dividend = denom - dividend;
                dividend = dividend << 1;
                res = res << 1;
            }
            cur = cur >> 1;
        }
        q = q + res;
        return q;
    }
}

package leetcode.medium;

/**
 * Created by Vamsi on 5/9/2017.
 */
public class PowXN {
    public static void main(String[] args) {
        PowXN x = new PowXN();
        System.out.println(x.myPow(-1.00000, -2147483648));
        System.out.println(Integer.MIN_VALUE +" "+Integer.MAX_VALUE);
    }
    public double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            return (1/x) *myPow(1/x, -(n+1));
        }

        if(n < 0){
            n = -n;
            System.out.println(n);
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2): x*myPow(x*x, n/2);
    }
}

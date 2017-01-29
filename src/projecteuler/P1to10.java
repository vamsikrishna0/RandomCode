package projecteuler;

import java.math.BigInteger;

/**
 * Created by Vamsi on 1/25/2017.
 */
public class P1to10 {
    public static void main(String[] args) {
        P1to10 x = new P1to10();
//        System.out.println(x.evenFibonaccinumbers(10));
//        System.out.println(x.evenFibonaccinumbers(100));
        System.out.println(Integer.MAX_VALUE +" "+Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
    //1. Multiples of 3 and 5
    BigInteger multiplesof3and5(int n){
        BigInteger sum = BigInteger.ZERO;
        long p = n;
        while(p-- >0){
            if(p % 3 ==0)
                break;
        }
        p /= 3;
        String k = ""+((p * (p+1)) *3)/2;
        BigInteger sum2 = new BigInteger(k);
        sum = sum.add(sum2);

        p = n;
        while(p-- >0){
            if(p % 5 ==0)
                break;
        }
        p /= 5;
        String k3 = ""+((p * (p+1)) *5)/2;
        BigInteger sum3 = new BigInteger(k3);
        sum = sum.add(sum3);

        p = n;
        while(p-- >0){
            if(p % 15 ==0)
                break;
        }
        p /= 15;
        String k4 = ""+((p * (p+1)) *15)/2;
        BigInteger sum4 = new BigInteger(k4);
        sum = sum.subtract(sum4);

        System.out.println(sum);
        return sum;
    }

    //2: Even Fibonacci numbers
    BigInteger evenFibonaccinumbers(long n){
        BigInteger en = new BigInteger(n+"");
        BigInteger two = new BigInteger(2+"");
        BigInteger sum0 = BigInteger.ONE;
        BigInteger sum1 = BigInteger.ONE;
        BigInteger sum2 = sum0.add(sum1);
        BigInteger finalSum = BigInteger.ZERO;
        while(sum2.compareTo(en) <=0){
            if(sum2.remainder(two).compareTo(BigInteger.ZERO) == 0){
                finalSum = finalSum.add(sum2);
            }
            sum0 = sum1;
            sum1 = sum2;
            sum2 = sum0.add(sum1);
        }

        System.out.println(finalSum);
        return finalSum;
    }
}

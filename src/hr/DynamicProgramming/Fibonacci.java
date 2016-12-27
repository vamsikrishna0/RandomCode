package hr.DynamicProgramming;

import java.util.HashMap;

/**
 * Created by Vamsi on 12/23/2016.
 */
public class Fibonacci {

    public static void main(String[] args) {
        fib = new HashMap<>();

        // Base cases
        fib.put(0, (long)0);
        fib.put(1, (long)1);

        System.out.println(fibonacciMemoized(80));
        System.out.println(fibonacciBottomUp(80));
    }

    //Memoized version of fibonacci
    public static HashMap<Integer, Long> fib;
    public static long fibonacciMemoized(int n){

        if(fib.containsKey(n))
            return fib.get(n);
        else{
            long fibn = fibonacciMemoized(n -1) + fibonacciMemoized(n-2);
            fib.put(n, fibn);
            return fibn;
        }
    }

    //The Bottom-up or tabulated version of fibonacci
    public static long fibonacciBottomUp(int n){
        //The memory is used and then returned once the code exits the method.
        HashMap<Integer, Long> fib = new HashMap<>();
        fib.put(0, (long)0);
        fib.put(1, (long)1);

        for (int i = 2; i <= n; i++) {
            fib.put(i, fib.get(i-1)+fib.get(i-2));
        }
        return fib.get(n);
    }
}

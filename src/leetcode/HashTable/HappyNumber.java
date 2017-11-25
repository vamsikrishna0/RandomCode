package leetcode.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber x = new HappyNumber();
        System.out.println(x.sumOfSquaresOfDigits(7));
        System.out.println(x.isHappy(7));
    }
    public boolean isHappy(int n) {
        int res = sumOfSquaresOfDigits(n);;
        Set<Integer> inter = new HashSet<>();
        while(res != 1){
            if(inter.contains(res)){
                return false;
            }else{
                inter.add(res);
                res = sumOfSquaresOfDigits(res);
            }
        }
        return true;
    }
    private int sumOfSquaresOfDigits(int n){
        int res = 0;
        int p;
        while(n > 0){
            p = n % 10;
            res += (p * p);
            n /= 10;
        }
        return res;
    }
}

package leetcode.HashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
        FractiontoRecurringDecimal x = new FractiontoRecurringDecimal();

//        System.out.println(x.fractionToDecimal(1, 5));
//        System.out.println(x.fractionToDecimal(3156, 3160));
        System.out.println(Math.pow(2, 28) * 4 <= Integer.MAX_VALUE);
    }
    public String fractionToDecimal(int num,  int denom) {
        StringBuilder res = new StringBuilder();
        String sign = (num < 0 == denom < 0 || num == 0) ? "" : "-";
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)denom);
        res.append(sign);
        res.append(numerator/denominator);

        long rem = numerator % denominator;
        long div;
        if(rem == 0)
            return res.toString();
        res.append('.');
        HashMap<Long, Integer> reminders = new HashMap<>();
        while(!reminders.containsKey(rem)){
            reminders.put(rem, res.length());
            rem *= 10;
            div = rem / denominator;
            rem = rem % denominator;
            res.append(div);
        }

        return res.insert((int)reminders.get(rem), '(').append(')').toString().replace("(0)", "");
    }
}

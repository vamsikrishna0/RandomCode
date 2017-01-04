package leetcode;

/**
 * Created by Vamsi on 12/29/2016.
 */
public class StringToInteger {
    //Given a string convert it to integer
    public static void main(String[] args) {
        StringToInteger x = new StringToInteger();
        System.out.println(x.myAtoi("      -11919730356x"));
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
    }

    public int myAtoi(String str) {
        if (str == null || str.length() <= 0 || str.isEmpty())
            return 0;

        str = str.trim();
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            sign = 1;
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                str = str.substring(0, i);
            }
        }

        if (str.length() < 1)
            return 0;
        if (str.length() > 10) {
            if (sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }

        String strMax = String.valueOf(Integer.MAX_VALUE);
        if (str.isEmpty())
            return 0;
        long temp = Long.parseLong(str);

        if (temp > Integer.MAX_VALUE && sign == 1)
            return Integer.MAX_VALUE;
        else if (temp > (long) Integer.MIN_VALUE * -1 && sign == -1)
            return Integer.MIN_VALUE;
        else
            return sign * (int) temp;
    }
}

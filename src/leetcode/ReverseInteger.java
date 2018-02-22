package leetcode;

/**
 * Created by Vamsi on 12/29/2016.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger x = new ReverseInteger();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(x.reverse(1534236469));
        String y = String.valueOf(123);

        System.out.println(String.valueOf(123) + String.valueOf(5123));

    }
    public int reverse(int x) {
        //The mathematical way
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;

        //Converting to string and then reversing
        /*String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        if(str.charAt(0) == '-'){
            builder.append('-');
            str = str.substring(1);
        }

        for(int i=str.length()-1; i>= 0; i--){
            builder.append(str.charAt(i));
        }

        long res =  Long.parseLong(builder.toString());
        if(res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE)
            return (int)res;
        else
            return 0;*/
    }
}

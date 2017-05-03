package leetcode.medium;

/**
 * Created by Vamsi on 1/28/2017.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings x = new MultiplyStrings();
        long p = Long.parseLong("999999999999999");
        double z = (double)Math.pow(9999, 2);
        System.out.println(Integer.MAX_VALUE +" "+ z);
        System.out.println(x.multiply("9999", "999999") +" "+(p+999999));
    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
                assert j == 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String sum(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        sum(num1, num2, sb, false, 1);
        return sb.reverse().toString();
    }
    static char o = '0';
    void sum(String num1, String num2, StringBuilder sb, boolean car, int pos){
        if(num1.length() - pos < 0 && num2.length() - pos < 0){
            if(car) sb.append(1);
            return;
        }
        int t, num = 0;
        if(num1.length() - pos < 0 || num2.length() - pos < 0){
            if(num1.length() - pos < 0)
                num = num2.charAt(num2.length() - pos) - o;
            else if(num2.length() - pos < 0)
                num = num1.charAt(num1.length() - pos) - o;

            if(car){
                car = ((num +1)/10) == 1;
                sb.append((num +1)%10);
            }
            sum(num1, num2, sb, car, pos + 1);
            return;
        }

        int d1 = num1.charAt(num1.length() - pos) - o;
        int d2 = num2.charAt(num2.length() - pos) - o;
        num = d1 + d2 + (car ? 1 : 0);
        int d = num %10;
        car = (num /10)==1;
        sb.append(d);
        sum(num1, num2, sb, car, pos+1);
    }
}

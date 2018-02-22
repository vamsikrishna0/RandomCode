package leetcode;

import java.util.HashMap;

/**
 * Created by Vamsi on 12/31/2016.
 */
public class IntegerToRoman {
    //Convert an integer to a roman representatiom
    public static void main(String[] args) {

    }
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        while(num >= 1000){
            builder.append('M');
            num -= 1000;
        }
        if(num >= 900){
            builder.append("CM");
            num -= 900;
        }
        if(num >= 500){
            builder.append('D');
            num -= 500;
        }
        if(num >= 400){
            builder.append("CD");
            num -= 400;
        }
        while(num >= 100){
            builder.append('C');
            num -= 100;
        }
        if(num >= 90){
            builder.append("XC");
            num -= 90;
        }
        if(num >= 50){
            builder.append('L');
            num -= 50;
        }
        if(num >= 40){
            builder.append("XL");
            num -= 40;
        }
        while(num >= 10){
            builder.append('X');
            num -= 10;
        }
        if(num >= 9){
            builder.append("IX");
            num -= 9;
        }
        if(num >= 5){
            builder.append('V');
            num -= 5;
        }
        if(num >= 4){
            builder.append("IV");
            num -= 4;
        }
        while(num > 0){
            builder.append('I');
            num -= 1;
        }
        return builder.toString();
    }
    public int romanToInt(String s) {
        int len = s.length();
        HashMap<Character, Integer> intValues = new HashMap<>();
        intValues.put('I',1);
        intValues.put('V',5);
        intValues.put('X',10);
        intValues.put('L',50);
        intValues.put('C',100);
        intValues.put('D',500);
        intValues.put('M',1000);
        int intSum = 0;
        int i=0;
        while(i< len){
            char c = s.charAt(i);
            if(i+1 < len){
                char d = s.charAt(i+1);
                if(intValues.get(c) >= intValues.get(d)){
                    intSum += intValues.get(c);
                    i++;
                }else{
                    intSum += (intValues.get(d) - intValues.get(c));
                    i += 2;
                }
            }else{
                intSum += intValues.get(c);
                i++;
            }
        }

        return intSum;
    }
}

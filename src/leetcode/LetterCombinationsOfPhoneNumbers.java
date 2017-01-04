package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class LetterCombinationsOfPhoneNumbers {
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumbers x = new LetterCombinationsOfPhoneNumbers();
        List<String> res = x.letterCombinations("23");
        for (String w: res) {
            System.out.println(w);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())  {
            return res;
        }


        int len = digits.length();
        int first = Integer.parseInt(digits.charAt(0)+"");
        List<Character> chars = new ArrayList<>();
        switch (first){
            case 2:
                chars.add('a');
                chars.add('b');
                chars.add('c');
                break;
            case 3:
                chars.add('d');
                chars.add('e');
                chars.add('f');
                break;
            case 4:
                chars.add('g');
                chars.add('h');
                chars.add('i');
                break;
            case 5:
                chars.add('j');
                chars.add('k');
                chars.add('l');
                break;
            case 6:
                chars.add('m');
                chars.add('n');
                chars.add('o');
                break;
            case 7:
                chars.add('p');
                chars.add('q');
                chars.add('r');
                chars.add('s');
                break;
            case 8:
                chars.add('t');
                chars.add('u');
                chars.add('v');
                break;
            case 9:
                chars.add('w');
                chars.add('x');
                chars.add('y');
                chars.add('z');
                break;
        }
        if(len ==1){
            for (char c: chars) {
                res.add(c+"");
            }
            return res;
        }

        List<String> subRes = letterCombinations(digits.substring(1));
        for (char c: chars) {
            for (String str: subRes) {
                res.add(c+str);
            }
        }
        return res;
    }
}

package leetcode.easy;

import java.util.Arrays;

/**
 * Created by Vamsi on 4/26/2017.
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String x = "bdkuf hsdgk jsgf";
        ReverseWordsInAStringIII dd = new ReverseWordsInAStringIII();
        StringBuilder w = new StringBuilder(x);
        System.out.println(dd.reverseWords(x));
    }
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder w = new StringBuilder();
        for (String x: strArr) {
            w.append(new StringBuilder(x).reverse()).append(" ");
        }
        w.deleteCharAt(w.length()-1);
        return w.toString();
    }
}

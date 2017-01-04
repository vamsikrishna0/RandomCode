package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Vamsi on 1/4/2017.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        String x = "abc";
        StringBuilder y = new StringBuilder("abc");
        y.insert(2, "xyz");
        System.out.println(y);
        GenerateParentheses z = new GenerateParentheses();
        List<String> strs = z.generateParenthesis(8);
        for (String b: strs
             ) {
            System.out.println(b);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0)
            return null;
        if(n == 1){
            res.add("()");
            return res;
        }
        res = generateParenthesis(n-1);
        HashSet<String> parset = new HashSet<>();
        for(String par: res){
            for(int i=0; i< par.length(); i++){
                StringBuilder builder = new StringBuilder(par);
                parset.add(builder.insert(i, "()").toString());
            }
        }
        return new ArrayList<>(parset);
    }
}

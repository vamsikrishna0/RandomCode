package leetcode.easy;

/**
 * Created by Vamsi on 1/27/2017.
 */
public class CountAndSay {

    //38. Count and Say
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String str = "11";
        StringBuilder res = new StringBuilder();
        int p;
        while(n-- > 2){
            p = 1;
            int len = str.length()-1;
            for(int i=0; i<len; i++){
                if(str.charAt(i) == str.charAt(i+1))
                    p++;
                else{
                    res.append(p).append(str.charAt(i));
                    p = 1;
                }
            }
            if(str.charAt(len) == str.charAt(len-1)){
                res.append(p).append(str.charAt(len));
            }else{
                res.append(1).append(str.charAt(len));
            }
            str = res.toString();
            res = new StringBuilder();
        }
        return str;
    }

}

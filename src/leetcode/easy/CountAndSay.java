package leetcode.easy;

/**
 * Created by Vamsi on 1/27/2017.
 *
 The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"

 Example 2:

 Input: 4
 Output: "1211"

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
            int len = str.length();
            for(int i=0; i<len; i++){
                if(str.charAt(i) == str.charAt(i+1))
                    p++;
                else{
                    res.append(p).append(str.charAt(i));
                    p = 1;
                }
            }
            res.append(p).append(str.charAt(len));
            str = res.toString();
            res = new StringBuilder();
        }
        return str;
    }

}

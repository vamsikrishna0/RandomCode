package hr.Strings;

import java.util.*;

/**
 * Created by Vamsi on 10/27/2016.
 */
public class SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int len = str.length();
            int count = 0;
            for (int j = 1; j < len; j++) {
                HashMap<String, Integer> substrings = new HashMap<>();
                for (int k = 0; k <= len - j; k++) {
                    char[] chars = str.substring(k, k+j).toCharArray();
                    Arrays.sort(chars);
                    String temp = new String(chars);
                    substrings.put(temp, substrings.getOrDefault(temp, 0)+1);
                }
                for(int x: substrings.values()){
                    if(x >=2)
                        count += nC2(x);
                }
            }
            System.out.println(count);
        }
    }

    public static int nC2(int n){
        return (n * (n-1))/2;
    }
}

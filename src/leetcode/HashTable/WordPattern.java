package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class WordPattern{
    public static void main(String[] args) {
        WordPattern x = new WordPattern();
        System.out.println(x.wordPattern2("abba", "dog cat cat dog"));
    }
    public boolean wordPattern(String pattern, String str) {
        StringBuilder patternsb = new StringBuilder();
        HashMap<Character, Integer> patternCode = new HashMap<>();
        int p = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(patternCode.containsKey(c)){
                patternsb.append(patternCode.get(c));
            }else{
                p++;
                patternsb.append(p);
                patternCode.put(c, p);
            }
        }
        p = 0;
        String[] strArr = str.split(" ");
        HashMap<String, Integer> strCode = new HashMap<>();
        StringBuilder strsb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String c = strArr[i];
            if(strCode.containsKey(c)){
                strsb.append(strCode.get(c));
            }else{
                p++;
                strsb.append(p);
                strCode.put(c, p);
            }
        }
        return patternsb.toString().equals(strsb.toString());
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

}

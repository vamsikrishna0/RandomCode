package leetcode.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Vamsi on 4/1/2017.
 */
public class KeyboardRow {
    public static void main(String[] args) {
        KeyboardRow x = new KeyboardRow();
        String[] words = {"Hello", "Alaska", "Dad", "Peace", "a"};
        for (String p: x.findWords(words)
             ) {
            System.out.println(p);
        }
    }
    public String[] findWords(String[] words) {
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            for (char c: lines[i].toCharArray()) {
                charMap.put(c, i);
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for(String word: words){
            if(word.length() == 1)
                res.add(word);
            else if(word.length() > 1){
                boolean p = true;
                for (int i = 1; i < word.length(); i++) {
                    if(charMap.get(Character.toLowerCase(word.charAt(i))) != charMap.get(Character.toLowerCase(word.charAt(0)))){
                        p = false;
                        break;
                    }
                }
                if(p) res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

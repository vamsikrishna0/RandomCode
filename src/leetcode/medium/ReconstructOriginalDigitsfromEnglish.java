package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsfromEnglish {

    public String originalDigits(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        String[] arrStrs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('w', 2);
        map1.put('u', 4);
        map1.put('x', 6);
        map1.put('g', 8);
        Map<Character, Integer> map2 = new HashMap<>();
        map2.put('o', 1);
        map2.put('t', 3);
        map2.put('f', 5);
        map2.put('s', 7);

        boolean[] status = new boolean[10];

        for (char c: map1.keySet()) {
            if(freq.get(c) != 0){
                status[map1.get(c) - 1] = true;
                String p = arrStrs[map1.get(c) - 1];
                for (char ch: p.toCharArray()) {
                    freq.put(ch, freq.get(ch) - 1);
                }
            }
        }

        for (char c: map1.keySet()) {
            if(freq.get(c) != 0){
                status[map1.get(c) - 1] = true;
                String p = arrStrs[map1.get(c) - 1];
                for (char ch: p.toCharArray()) {
                    freq.put(ch, freq.get(ch) - 1);
                }
            }
        }
        return "";
    }
}

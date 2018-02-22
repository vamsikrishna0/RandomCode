package leetcode.HashTable;

import java.util.*;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        FindAllAnagramsinaString x = new FindAllAnagramsinaString();

    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p== null || s.length() < p.length() || p.length() == 0)
            return res;
        int plen = p.length();
        int[] pmap = new int[26];
        int[] smap = new int[26];
        for (int i = 0; i < plen; i++) {
            pmap[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < plen; i++) {
            smap[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pmap, smap))
            res.add(0);

        for (int i = plen; i < s.length(); i++) {
            smap[s.charAt(i-plen) - 'a']--;
            smap[s.charAt(i) - 'a']++;
            if(Arrays.equals(pmap, smap))
                res.add(i-plen+1);
        }
        return res;
    }
}

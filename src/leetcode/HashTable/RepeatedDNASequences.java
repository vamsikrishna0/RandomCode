package leetcode.HashTable;

import java.util.*;

/**
 * Created by Vamsi on 6/6/2017.
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences x = new RepeatedDNASequences();
        for(String s: x.findRepeatedDnaSequences("AAAAAAAAAAA")){
            System.out.println(s);
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> sequencefreqmap = new HashMap<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            sequencefreqmap.put(sub, sequencefreqmap.getOrDefault(sub, 0) + 1);
        }
        for (String str : sequencefreqmap.keySet()) {
            if(sequencefreqmap.get(str) > 1)
                res.add(str);
        }
        return res;
    }


    // Beautiful solution using rolling hashes.
    private static final Map<Character, Integer> A = new HashMap<>();
    static { A.put('A',0); A.put('C',1); A.put('G',2); A.put('T',3); }
    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

    public List<String> findRepeatedDnaSequences3(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i-10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new ArrayList<>();
        Set<String> uniquesequences = new HashSet<>();
        Set<String> repeatedsequences = new HashSet<>();
        System.out.println(s.length());
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            if(!uniquesequences.add(sub))
                repeatedsequences.add(sub);
        }
        res.addAll(repeatedsequences);
        return res;
    }
}

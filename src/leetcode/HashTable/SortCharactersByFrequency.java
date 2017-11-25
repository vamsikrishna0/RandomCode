package leetcode.HashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Vamsi on 6/13/2017.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>(1, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.val > o2.val)
                    return -1;
                else if (o1.val < o2.val)
                    return 1;
                else return 0;
            }
        });
        for (char c: freq.keySet()) {
            Pair p = new Pair(freq.get(c),c);
            heap.add(p);
        }

        StringBuilder res = new StringBuilder();
        while(!heap.isEmpty()){
            Pair p = heap.poll();
            for (int i = 0; i < p.val; i++) {
                res.append(p.ch);
            }
        }
        return res.toString();
    }
    private class Pair {
        int val;
        char ch;

        public Pair(int val, char ch) {
            this.val = val;
            this.ch = ch;
        }
    }
}


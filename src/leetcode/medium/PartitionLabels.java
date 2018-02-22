package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Map<Character, int[]> limits = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            int[] p = limits.getOrDefault(c, new int[]{i,i});
            p[1] = i;
            limits.put(c, p);
        }
        int start = 0, end=0;
        while(end <= S.length()-1){
            int[] curlimits = limits.get(S.charAt(start));
            end = curlimits[1];
            int i=start +1;
            while(i >= start && i <= end){
                int[] curlimits2 = limits.get(S.charAt(i));
                if(curlimits2[1] > end){
                    end = curlimits2[1];
                }
                i++;
            }
            res.add(end - start + 1);
            start = end = end+1;
        }
        return res;
    }
}

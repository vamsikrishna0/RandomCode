package leetcode.HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Vamsi on 6/4/2017.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int len = citations.length;
        if (citations[0] >= len)
            return len;
        if (citations[len - 1] < 1)
            return 0;
        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] == len - i)
                return citations[i];
            else if (citations[i] < len - i)
                return len - i - 1;
        }
        return 0;
    }
    //Exchanging running time for space.
    //O(n) extra space O(n) running time
    public int hIndex2(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];

        for (int c: citations)
            if (c > len)
                count[len]++;
            else
                count[c]++;

        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }

        return 0;
    }
}

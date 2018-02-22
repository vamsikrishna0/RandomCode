package leetcode.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> candytypes = new HashSet();
        for (int i = 0; i < candies.length; i++) {
            candytypes.add(candies[i]);
        }
        return (candytypes.size() > candies.length / 2) ? (candies.length / 2):(candytypes.size());
    }
}

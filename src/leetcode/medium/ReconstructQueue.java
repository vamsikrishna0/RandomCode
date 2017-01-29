package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vamsi on 1/23/2017.
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return new int[0][0];
        int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0])
                    return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        res.add(people[0]);
        int[] x;
        for (int i = 1; i < n; i++) {
            /*
            For each element x in the sorted array, put it in the result set after x[1] elements of the result array.
            This works because as we are accessing elements in decreasing order, at any point all the elements already in the result set
            >= to this element. So insertion can happen as we do in an insertion sort. And to do it efficiently use a list DS.
            */
            x = people[i];
            res.add(x[1], x);
        }
        return res.toArray(new int[0][]);
    }
}

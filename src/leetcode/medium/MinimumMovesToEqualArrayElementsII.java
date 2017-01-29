package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vamsi on 1/22/2017.
 */
public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
    }

    /*
    // find the minimum number of moves required to make all array elements equal.
    // A move means either increasing or decreasing an element by 1.
    // Find the min sum of absolute deviations from any int element to all the elements in an array.
    * */
    public int minMoves2(int[] nums) {
        //Solution is basically finding the distance to median from all elements.
        // Why median? because its where their sum reduces to min.
        int len = nums.length;
        int sum = 0;

        List<int[]> res = new LinkedList<>();

        int[][] ints = res.toArray(new int[1][]);
        //Sorting and then finding abs diff between ith element from front and end.
        Arrays.sort(nums);
        int i = 0, j = len - 1;
        while (i < j) {
            sum += (nums[j] - nums[i]);
            i++;
            j--;
        }
        return sum;
    }
}

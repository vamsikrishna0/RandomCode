package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vamsi on 1/28/2017.
 */
public class CombinationSumII {
    //40. Combination Sum II
    public static void main(String[] args) {
        CombinationSumII x = new CombinationSumII();
        int[] ar = {10, 1, 2, 7, 6, 1, 5};
        for (List<Integer> p: x.combinationSum2(ar, 8)){
            for (int q: p)
                System.out.print(q + " ");
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, candidates.length - 1, target, res, list);
        return res;
    }

    //Everything similar to Combination sum, except skipping duplicates.
    void helper(int[] ar, int last, int target, List<List<Integer>> res, List<Integer> list){
        if(target < 0)
            return;
        if(target == 0){
            List<Integer> x = new ArrayList<>(list);
            res.add(x);
            return;
        }

        for(int i = last; i >= 0; i--){
            //Skip the duplicate elements.
            if(i < last && ar[i] == ar[i+1])  continue; // Key for the prob
            list.add(ar[i]);
            helper(ar, i - 1, target - ar[i], res, list);
            list.remove(list.size() - 1);
        }
    }

//    //Not required for the simplest base case.
//    int bSearch(int[] nums, int target, int j) {
//        int i = 0;
//        int res = -1, mid;
//        while (i <= j) {
//            mid = (i + j) / 2;
//            if (nums[mid] == target) {
//                res = mid;
//                break;
//            } else if (nums[mid] > target) {
//                j = mid - 1;
//            } else {
//                i = mid + 1;
//            }
//        }
//        return res;
//    }
}

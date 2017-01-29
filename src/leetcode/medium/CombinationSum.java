package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vamsi on 1/28/2017.
 */
public class CombinationSum {
    //39. Combinatio sum
    // *Canonical backtracking solution.*
    public static void main(String[] args) {
        CombinationSum x = new CombinationSum();
        int[] ar = {2, 3, 6, 7, 8};
        for (List<Integer> p: x.combinationSum(ar, 8)){
            for (int q: p)
                System.out.print(q + " ");
            System.out.println();
        }
    }

    /*
    * Approach 1:
    * Canonical backtracking solution.
    *
    * Create a helper function which does the recursion and gets back the results.
    * Like any backtracking solution, we create partial solutions and reject them the moment they are invalid.
    * Create a result DS and pass it around. Keep adding to the res when a solution is found.
    * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, candidates.length - 1, target, res, list);
        return res;
    }

    void helper(int[] ar, int last, int target, List<List<Integer>> res, List<Integer> list){
        //Reject base case
        if(target < 0)
            return;

        //Accept base case
        //This works with a bSearch happening for the target.
        // But we could just go for another recursion layer and forget about it altogether.
        /*if(bSearch(ar, target, last) != -1){
            List<Integer> x = new ArrayList<>(list);
            x.add(target);
            res.add(x);
        }*/

        //A simpler base case.
        if(target == 0)
            res.add(new ArrayList<>(list));

        //Recurse on subproblem part
        for(int i = last; i >=0; i--){
            if(ar[i] <= target){
                list.add(ar[i]);
                helper(ar, i, target - ar[i], res, list);
                list.remove(list.size()-1);
            }
            /* //Alternatively we could recurse on all possible partial problems & reject each of them at the start
               //of the helper function(if(target < 0)).

                list.add(ar[i]);
                helper(ar, i, target - ar[i], res, list);
                list.remove(list.size()-1);
            * */
        }
    }

    //Not required for the simplest base case.
    int bSearch(int[] nums, int target, int j) {
        int i = 0;
        int res = -1, mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }
}

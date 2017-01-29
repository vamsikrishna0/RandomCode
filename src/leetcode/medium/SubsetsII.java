package leetcode.medium;

import java.util.*;

/**
 * Created by Vamsi on 1/24/2017.
 */
public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII x = new SubsetsII();
        int[] nums = {1, 2, 2};
        for (List<Integer> p : x.subsetsWithDup(nums)) {
            for (int q : p)
                System.out.print(q);
            System.out.println();
        }
    }

    //Approach1:
    //A generic backtracking solution.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }

    //Generating subsets using backtracking. This is a recursive solution, which adds each subset once
    private void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        if (pos <= nums.length) res.add(new ArrayList<>(tmpRes));

        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;   // avoid duplicates
            tmpRes.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
    /*
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return res;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        makeSubsets(res, freq, new Stack<>());
        return res;
    }

    private void makeSubsets(List<List<Integer>> res, HashMap<Integer, Integer> freq, Stack<Integer> li) {
        boolean status = true;
        for (int p : freq.values()) {
            if (p != 0) {
                status = false;
                break;
            }
        }
        if (status)
            return;

        for (Integer key : freq.keySet()) {
            if (freq.get(key) != 0 && (li.isEmpty() || key >= li.peek())) {
                List<Integer> newList = new ArrayList<>();
                li.push(key);
                newList.addAll(li);
                res.add(newList);

                freq.put(key, freq.get(key) - 1);
                makeSubsets(res, freq, li);
                freq.put(key, freq.get(key) + 1);
                li.pop();
            }
        }
    }
    */
}

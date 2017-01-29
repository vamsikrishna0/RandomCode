package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamsi on 1/23/2017.
 */
public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int i=1;
        System.out.println(i-- == 0);
        System.out.println(i-- == 0);
        int[] p = {1, 2, 3};
        int[] z = p.clone();
    }
    /*
    442.
    1. We could use extra memory O(n) and do it in linear time(the general solution).
    2. We could also sort and then linear scan O(nlogn).
    3. A bit array to check if each element is already seen, which would take extra memory
    But here the constraints being 1<= a[i] <= n, (n is length of array). We could use the indices as place holders of duplicates.
    Instead we take the value of an index as p and negate the value at index p.
    So next time we se the same element that is already negative and hence add it as duplicate.
    Simply put negating an index is used in place of setting a bit in bit array.....Subtle. Very Subtle!
    * */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}

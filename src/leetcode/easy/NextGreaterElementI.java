package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Vamsi on 5/22/2017.
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        NextGreaterElementI x = new NextGreaterElementI();
        int[] w = {4, 1, 2};
        int[] k = {1,3,4,2};
        int[] res = x.nextGreaterElement(w, k);
        for (int r:res) {
            System.out.println(r);
        }
    }
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        //Critical idea is to use stack to put elements in, and add them to a map
        // as soon as you see the first number greater than it.

        //Key idea: Only put something on stack if the first element of it, is greater than the one in hand,
        // else keep populating the map as we have our "next greater after its index" for that particular number.
        for(int num : nums){
            while (!stack.isEmpty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }

        int[] res = new int[findNums.length];
        for(int i=0; i<findNums.length; i++){
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        return res;
    }
}

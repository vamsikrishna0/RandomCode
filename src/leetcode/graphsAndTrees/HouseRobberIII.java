package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/14/2017.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        //Using recursive algo
        //We return two values for each call: one which includes the element or node and one without
        SumRobbed p = maxAmount(root);
        return Math.max(p.withEl, p.withoutEl);
    }

    public SumRobbed maxAmount(TreeNode root){
        if(root == null)
            return new SumRobbed(0,0);

        SumRobbed left = maxAmount(root.left);
        SumRobbed right = maxAmount(root.right);
        SumRobbed res = new SumRobbed(0, 0);

        //The return value for amount robbed with the element is, value of element + value of left and right without those respective elements
        //i.e sum of values from sub problems, which doesn't include those elements
        res.withEl = left.withoutEl + right.withoutEl + root.val;

        //the return value for the amount without the element is, max of left values + max of right values
        res.withoutEl = Math.max(left.withoutEl , left.withEl) + Math.max(right.withEl , right.withoutEl);
        return res;
    }
    //Wrapper class for the two values. Encapsulated as an object
    private class SumRobbed{
        int withEl;
        int withoutEl;
        SumRobbed(int a, int b){
            withEl=a;
            withoutEl = b;
        }
    }

}

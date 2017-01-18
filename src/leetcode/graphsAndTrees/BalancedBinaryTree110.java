package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/16/2017.
 */
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBal;
    }
    public BalanceData helper(TreeNode root){
        if(root == null)
            return new BalanceData(0, true);
        BalanceData left = helper(root.left);
        BalanceData right = helper(root.right);
        if(left.isBal && right.isBal){
            if(Math.abs(left.height - right.height) <= 1){
                return new BalanceData(Math.max(left.height, right.height) + 1, true);
            }
        }
        return new BalanceData(0, false);
    }
    private class BalanceData{
        int height;
        boolean isBal;
        BalanceData(int h, boolean bal){
            height = h;
            isBal = bal;
        }
    }
}

package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/16/2017.
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum x = new PathSum();
        TreeNode w = new TreeNode(1);
        System.out.println(x.hasPathSum(w, 1));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if(root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }
    public int minDepth(TreeNode root) {
        if(root.right == null && root.left == null) return 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        if(root.left == null)
            return minDepth(root.right) + 1;
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}

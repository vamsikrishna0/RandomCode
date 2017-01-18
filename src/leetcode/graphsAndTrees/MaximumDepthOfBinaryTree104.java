package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/15/2017.
 */
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}

package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/14/2017.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;
        boolean left = isSameTree(p.left, q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right, q.right);
        if(!right) return false;

        return true;
    }
}

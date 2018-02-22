package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/16/2017.
 */
public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        ValidateBinarySearchTree98 x = new ValidateBinarySearchTree98();

    }
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.right == null && root.left == null))
            return true;
        if (root.right == null) {
            if (root.left.val >= root.val)
                return false;
            else
                return isValidBST(root.left);
        }
        if (root.left == null) {
            if (root.right.val <= root.val)
                return false;
            else
                return isValidBST(root.right);
        }
        return root.right.val > root.val && root.left.val < root.val && isValidBST(root.right) && isValidBST(root.left);
    }

}

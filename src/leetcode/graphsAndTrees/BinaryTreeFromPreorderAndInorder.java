package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

/**
 * Created by Vamsi on 1/18/2017.
 */
public class BinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length > 0 && inorder.length > 0)
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        else
            return null;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps < 0 || ps >= preorder.length || pe < 0 || pe >= preorder.length
                || is < 0 || is >= inorder.length || ie < 0 || ie >= inorder.length)
            return null;
        if(ps==pe )
            return new TreeNode(preorder[pe]);
        if(pe-ps == 1){
            TreeNode root = new TreeNode(preorder[ps]);
            if(inorder[is] == preorder[ps]){
                root.right = new TreeNode(preorder[pe]);
                return root;
            }else{
                root.left = new TreeNode(inorder[is]);
                return root;
            }
        }

        int elfirstp = preorder[ps];
        int root = Integer.MAX_VALUE;
        for(int i = is; i<=ie; i++){
            if(inorder[i] == elfirstp){
                root = i;
                break;
            }
        }
        int index = root - is;

        TreeNode rootEl = new TreeNode(elfirstp);
        if(ps+index+1 <= pe && root+1 <= ie)
            rootEl.right = buildTree(preorder, inorder, ps+index+1, pe, root+1, ie);
        if(ps+1 <= ps+index && is <= root-1)
            rootEl.left = buildTree(preorder, inorder, ps+1, ps+index, is, root-1);

        return rootEl;
    }

}

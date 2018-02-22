package leetcode.graphsAndTrees;

import leetcode.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamsi on 1/15/2017.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;

        List<String> left = binaryTreePaths(root.left);
        List<String> right= binaryTreePaths(root.right);
        if(!left.isEmpty()){
            for(String s : left){
                res.add(root.val +"->"+s);
            }
        }
        if(!right.isEmpty()){
            for(String s : right){
                res.add(root.val +"->"+s);
            }
        }
        if(left.isEmpty() && right.isEmpty())
            res.add(root.val+"");
        return res;
    }
}

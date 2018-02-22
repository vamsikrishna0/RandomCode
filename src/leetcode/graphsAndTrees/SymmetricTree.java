package leetcode.graphsAndTrees;

import crackingTheCodingInterview.SumTwoNumbersAsLinkedLists;
import leetcode.helpers.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Vamsi on 1/14/2017.
 */
public class SymmetricTree {
    private class SumRobbed{
        int withEl;
        int withoutEl;
        SumRobbed(int a, int b){
            withEl=a;
            withoutEl = b;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right));
    }

    //
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayDeque<TreeNode> b = new ArrayDeque<>();

        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

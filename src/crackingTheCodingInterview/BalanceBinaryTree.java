package crackingTheCodingInterview;

import crackingTheCodingInterview.helpers.BT;

/**
 * Created by Vamsi on 1/12/2017.
 */
public class BalanceBinaryTree{
    public boolean check(BT tree){
        return !(height(tree) == -1);
    }
    //PS: Using the fact that height is always positive and using -1 as the flag for not balanced subtree. Recursive!
    public int height(BT tree){
        if(tree == null)
            return 0;

        int resl = height(tree.left);
        if(resl == -1)
            return -1;

        int resr = height(tree.right);
        if(resr == -1)
            return -1;

        if((Math.abs(resl - resr) <= 1)){
            return Math.max(resl, resr) + 1;
        }else
            return -1;
    }


}


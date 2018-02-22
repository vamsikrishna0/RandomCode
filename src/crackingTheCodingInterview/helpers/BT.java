package crackingTheCodingInterview.helpers;

/**
 * Created by Vamsi on 1/12/2017.
 */
public class BT{
    public int val;
    public BT left;
    public BT right;
    public BT(BT left, BT right){
        this.left = left;
        this.right = right;
    }
}
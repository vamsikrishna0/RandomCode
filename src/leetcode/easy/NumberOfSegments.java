package leetcode.easy;

/**
 * Created by Vamsi on 7/18/2017.
 */
public class NumberOfSegments {
    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {
        return ("x +" + s).split(" +").length - 1;
    }
}

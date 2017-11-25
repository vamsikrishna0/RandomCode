package leetcode.easy;

/**
 * Created by Vamsi on 5/22/2017.
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()): -1;
    }
}

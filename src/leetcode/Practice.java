package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Vamsi on 11/11/2017.
 */
public class Practice {
    public static void main(String[] args) {
        String x = "ba ";

        //You add a sentinel string to account for the case where the given string starts with a space,
        // and hence the empty string at the front is taken care of.

        for (String c : x.split("b")) {
            System.out.println(c+':');
        }
    }
}

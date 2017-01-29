package interview.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Vamsi on 1/13/2017.
 */
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        LongestAbsoluteFilePath x = new LongestAbsoluteFilePath();
        System.out.println(x.lengthLongestPath(
                "dir\n" +
                        "\tsubdir1\n" +
                        "\t\tfile1.ext\n" +
                        "\t\tsubsubdir1\n" +
                        "\tsubdir2\n" +
                        "\t\tsubsubdir2\n" +
                        "\t\t\tfile2.ext"));
    }

    //An iterative DP solution
    public int lengthLongestPath(String S) {
        Deque<Integer> stack = new ArrayDeque<>();// Stores partial lengths of file paths each directory(including that)
        //Side Note: Use Deque for queue or stack implementation, as the "Stack" class in Java also inherits vector and bound to cause errors.

        stack.push(0); // "dummy" length => initial stack.size is 1
        int maxLen = 0;
        final String INDENT_STRING = "\t"; // Here indent string is "\t". Replace that with anything else

        //Looping over each substring str
        for (String str : S.split("\n")) {
            int lev = str.lastIndexOf(INDENT_STRING) + 1; // number of INDENT_STRINGs

            //Key Idea: using the indentation and comparing it to stack.size to get length of parent(length of absolute path)
            while (lev + 1 < stack.size()) stack.pop(); // find parent

            int len = stack.peek() + str.length() - lev + 1; // length after removing "/t"s, add"/"
            stack.push(len);

            // check if it is file and update maxLength
            if (str.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    ////////////////////////////////////////////
    private boolean isDirectory(String filename) {
        return (!filename.contains("."));
    }


    //Given a file name with leading spaces, return the count of them
    private int countLeadingSpaces(String file) {
        int j = 0;
        for (int i = 0; i < file.length(); i++) {
            if (file.charAt(i) == '\t')
                j++;
            else
                return j;
        }
        return j;
    }

    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0)
                    temp.append("Fizz");
                if (i % 5 == 0)
                    temp.append("Buzz");

            } else {
                temp.append(i);
            }
            res.add(temp.toString());
        }
        return res;
    }
}

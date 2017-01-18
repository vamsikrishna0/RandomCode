package crackingTheCodingInterview;

import java.util.*;

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
        List<String> res = x.fizzBuzz(5);
        System.out.println(res.size());
        for (String p : res) {
            System.out.println(p);
        }
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

    public int lengthLongestPath(String S) {
        Deque<Integer> stack = new ArrayDeque<>();// Stores partial lengths of file paths each directory(including that)
        stack.push(0); // "dummy" length => initial stack.size is 1
        int maxLen = 0;

        //Looping over each substring str
        for (String str : S.split("\n")) {
            int lev = str.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + str.length() - lev + 1; // length after removing "/t"s, add"/"
            stack.push(len);

            // check if it is file and update MaxLength
            if (str.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

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

}

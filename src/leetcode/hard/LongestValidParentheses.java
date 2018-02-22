package leetcode.hard;

import java.util.*;

/**
 * Created by Vamsi on 1/26/2017.
 */
public class LongestValidParentheses {
    //32. Longest Valid Parentheses
    public static void main(String[] args) {
        LongestValidParentheses x = new LongestValidParentheses();
        System.out.println(x.longestValidParentheses2("()"));
    }

    //O(n) solution: Solving each substring from start as a sub problem and building up the solution
    //In the previous solution we remembered way too much info. Most importantly the kind of sub problems we were solving were also more complex.

    /*
      Approach2:
    * Its an easier problem than the previous approach.
    * Here subproblems are substrings ending at each char from start. We have n such sub strings.
    *
    * Note: Here we learned that a problem can be solved in two different ways using DP itself.
    *       The key is to find out the right sub problems.
    * */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        final char op = '(';
        final char cl = ')';
        int curMax = 0;
        int len = s.length();
        int[] longest = new int[len];
        longest[0] = 0;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            char b = s.charAt(i - 1);
            if (c == cl) {
                if (b == op) {
                    longest[i] = (i - 2) >= 0 ? longest[i - 2] + 2 : 2;
                    curMax = Math.max(longest[i], curMax);
                } else {
                    if (i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == op) {
                        longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                        curMax = Math.max(longest[i], curMax);
                    }
                }
            }
        }
        return curMax;
    }

    /*
    * Approach 3
    * DP with '(' counter
    * */
    public int longestValidParentheses3(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
    /*
     * Approach 4
     * Using stack
     *
     * */
    public int longestValidParentheses4(String s) {
        int max = 0, start = 0;
        Stack<Integer> stack = new Stack();
        int[] a = new int[s.length()];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') stack.push(i);
            else if (!stack.empty()) {
                start = stack.pop();
                a[i] = i - start + 1;
                if (start > 1) a[i] += a[start - 1];
                max = Math.max(max, a[i]);
            }
        }
        return max;
    }

    //O(n^2) DP solution. But there exists an O(n) solution
    public int longestValidParentheses(String s) {
        final char op = '(';
        final char cl = ')';
        List<Set<Integer>> fli = new ArrayList<>();
        Set<Integer> li = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == op && s.charAt(i + 1) == cl) {
                li.add(i);
            }
        }
        fli.add(li);


        for (int i = 1; i <= (len / 2) + 1; i++) {
            int n = i, m = 1, off = i * 2;
            Set<Integer> r = new HashSet<>();
            li = fli.get(i - 1);

            for (int p : li) {
                if (p - 1 >= 0 && p + off <= len - 1 &&
                        s.charAt(p - 1) == op && s.charAt(p + off) == cl)
                    r.add(p - 1);
            }
//            printList(li);
//            printList(r);
//            System.out.println("li");
            while (n >= m) {
                int off1 = n * 2, off2 = m * 2;
//                System.out.println(off1 +" "+off2);
                Set<Integer> li1 = fli.get(n - 1);
                Set<Integer> li2 = fli.get(m - 1);
                for (int p : li1) {
                    if (p - off2 >= 0 && li2.contains(p - off2))
                        r.add(p - off2);
                    if (p + off1 <= len - 1 && li2.contains(p + off1))
                        r.add(p);
                }

//                printList(r);
                for (int p : li2) {
                    if (p - off1 >= 0 && li1.contains(p - off1))
                        r.add(p - off1);
                    if (p + off2 <= len - 1 && li1.contains(p + off2))
                        r.add(p);
                }
//                printList(r);
                n--;
                m++;
            }
            fli.add(r);
        }
        for (int i = (len / 2) + 1; i >= 0; i--) {
            if (!fli.get(i).isEmpty()) {
                return (i + 1) * 2;
            }
        }
        return 0;
    }

    private void printList(List<Integer> li) {
        for (int p :
                li) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

}


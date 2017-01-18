package crackingTheCodingInterview;

import leetcode.ListNode;

import java.util.PriorityQueue;

/**
 * Created by Vamsi on 1/9/2017.
 */
public class SumTwoNumbersAsLinkedLists {
    PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) {
        SumTwoNumbersAsLinkedLists temp = new SumTwoNumbersAsLinkedLists();
        ListNode x = new ListNode(5);
        ListNode y = new ListNode(5);
        ListNode z = temp.addTwoNumbers(x, y);
        while (z != null) {
            System.out.println(z.val);
            z = z.next;
        }
    }

    public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        return sumTwoNumbersWithCarry(n1, n2, 0);
    }

    ListNode sumTwoNumbersWithCarry(ListNode n1, ListNode n2, int carry) {
        if (n1 == null) {
            if (n2 == null) {
                if (carry == 1)
                    return new ListNode(1);
                return null;
            } else {
                if (carry == 1)
                    return sumTwoNumbersWithCarry(new ListNode(0), n2, carry);
                else return n2;
            }
        } else if (n2 == null) {
            if (carry == 1)
                return sumTwoNumbersWithCarry(n1, new ListNode(0), carry);
            else return n1;
        }

        int sum = n1.val + n2.val + carry;
        int val = sum % 10;
        int nextCarry = sum / 10;
        ListNode res = new ListNode(val);
        res.next = sumTwoNumbersWithCarry(n1.next, n2.next, nextCarry);
        return res;
    }
}

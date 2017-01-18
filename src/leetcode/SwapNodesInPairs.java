package leetcode;

/**
 * Created by Vamsi on 1/4/2017.
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs x = new SwapNodesInPairs();
        ListNode w = new ListNode(1);
        System.out.println(x.swapPairs(w).val);

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode res = head.next;
        ListNode p = head.next;
        ListNode b  = p.next;
        p.next = head;
        head.next = swapPairs(b);
        return res;
    }
}

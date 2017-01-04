package leetcode;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                ListNode temp = new ListNode(l2.val);
                res.next = temp;
                res = res.next;
                l2 = l2.next;
            }else{
                ListNode temp = new ListNode(l1.val);
                res.next = temp;
                res = res.next;
                l1 = l1.next;
            }
        }

        if(l2 == null){
            res.next = l1;
        }else{
            res.next = l2;
        }
        return head.next;
    }
}

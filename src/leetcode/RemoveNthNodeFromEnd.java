package leetcode;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
/*
        ListNode nth = head;
        ListNode present = head;
        while(present.next != null){
            if(n>0){
                present = present.next;
                n--;
            }else{
                present = present.next;
                nth = nth.next;
            }
        }
        if(n==1){
            head = head.next;
            return head;
        }else if(n >1){
            return null;
        }
        ListNode temp = nth.next;
        nth.next = nth.next.next;
        temp.next = null;
        return head;*/
    }
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


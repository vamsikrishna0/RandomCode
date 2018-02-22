package leetcode;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists x = new MergeKSortedLists();
        ListNode[] b = new ListNode[0];
        x.mergeKLists(b);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode[] subLists = new ListNode[(int)Math.ceil(len/2.0)];
        if(len == 0){
            return null;
        }
        if(len == 1){
            return lists[0];
        }
        int j = 0;
        for (int i = 0; i < len; i+=2) {
            if(i+1 < len){
                subLists[j] = merge2Lists(lists[i], lists[i+1]);
            }else{
                subLists[j] = lists[i];
            }
            j++;
        }
        return mergeKLists(subLists);
    }

    public ListNode merge2Lists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode res = head;

        while(a != null && b != null){
            if(a.val < b.val){
                head.next = a;
                head = head.next;
                a = a.next;
            }else{
                head.next = b;
                head = head.next;
                b = b.next;
            }
        }
        if(a == null){
            head.next = b;
        }else{
            head.next = a;
        }
        return res.next;
    }
}

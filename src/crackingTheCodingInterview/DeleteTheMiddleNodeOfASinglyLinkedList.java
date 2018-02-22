package crackingTheCodingInterview;
import leetcode.ListNode;
/**
 * Created by Vamsi on 1/9/2017.
 */

public class DeleteTheMiddleNodeOfASinglyLinkedList {

    //delete a node in the middle of a singly linked list, given only access to that node.
    public void deleteMiddle(ListNode node){
        if (node == null)
            return;

        while(node.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node = null;
        return;
    }
}

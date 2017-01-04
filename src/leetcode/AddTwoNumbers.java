package leetcode;

public class AddTwoNumbers {
    //Given two numbers as a lnked list representaion of their digits, find the sum with the same representation
    public static void main(String[] args) {
        AddTwoNumbers temp = new AddTwoNumbers();
        ListNode x = new ListNode(5);
        ListNode y = new ListNode(5);
        ListNode z = temp.addTwoNumbers(x, y);
        while (z != null) {
            System.out.println(z.val);
            z = z.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;

        //Putting the final result in l1: "No extra space"
        ListNode head = l1;
        int val = 0, car = 0;

        //Running the summation till the min length of both numbers
        while (l1 != null && l2 != null) {
            int sumOfDigits = l1.val + l2.val;

            if (carry) {
                sumOfDigits++;
            }
            val = sumOfDigits % 10;
            car = sumOfDigits / 10;
            l1.val = val;
            carry = (car == 1);

            //Breaking when l1 and l2 are not null, i.e one of them is last element
            if (l1.next == null || l2.next == null) {
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1.next == null) {
            //When l1 and l2 are of same size
            if (l2.next == null) {

                //Check for carry and add the carry node at the end
                if (carry) {
                    l1.next = new ListNode(1);
                    carry = false;
                }
            } else {//l2 is greater so connect l1's final next, to l2 at this position
                l1.next = l2.next;
                l1 = l1.next;
            }
        }
        // When l1 is greater than l2
        else {
            l1 = l1.next;
        }

        //Run through the remaining elements to check if carry exists and take the action needed
        while (l1 != null && carry) {
            val = l1.val + 1;

            car = val / 10;
            val = val % 10;
            l1.val = val;
            carry = (car == 1);

            if (l1.next == null) {
                if (carry) {
                    l1.next = new ListNode(1);
                    carry = false;
                }
            }
            l1 = l1.next;
        }

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
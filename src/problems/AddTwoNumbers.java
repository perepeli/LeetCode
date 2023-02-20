package problems;

import problems.listnode.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue = new LinkedList<>();

        boolean carry = false;

        while(l1 != null && l2 != null) {
            int newNum = l1.val + l2.val + (carry ? 1 : 0);
            carry = false;

            if(newNum > 9) {
                carry = true;
                queue.offer(newNum - 10);
            } else {
                queue.offer(newNum);
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int newNum = l1.val + (carry ? 1 : 0);
            carry = false;

            if(newNum > 9) {
                carry = true;
                queue.offer(newNum - 10);
            } else {
                queue.offer(newNum);
            }
            l1 = l1.next;
        }

        while(l2 != null) {
            int newNum = l2.val + (carry ? 1 : 0);
            carry = false;

            if(newNum > 9) {
                carry = true;
                queue.offer(newNum - 10);
            } else {
                queue.offer(newNum);
            }
            l2 = l2.next;
        }

        if(carry) queue.offer(1);

        ListNode dummy = new ListNode();

        ListNode temp = dummy;

        while(!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.poll());
            temp.next = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }
}

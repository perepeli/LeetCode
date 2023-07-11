package problems;

import problems.util.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode node = dummy;

        boolean overflow = false;

        while(l1 != null && l2 != null) {
            int digit = l1.val + l2.val + (overflow ? 1 : 0);
            overflow = false;

            ListNode newNode = new ListNode();

            if(digit > 9) {
                newNode.val = digit % 10;
                overflow = true;
            } else {
                newNode.val = digit;
            }

            node.next = newNode;
            node = node.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int digit = l1.val + (overflow ? 1 : 0);
            overflow = false;

            ListNode newNode = new ListNode();

            if(digit > 9) {
                newNode.val = digit % 10;
                overflow = true;
            } else {
                newNode.val = digit;
            }

            node.next = newNode;
            node = node.next;

            l1 = l1.next;
        }

        while(l2 != null) {
            int digit = l2.val + (overflow ? 1 : 0);
            overflow = false;

            ListNode newNode = new ListNode();

            if(digit > 9) {
                newNode.val = digit % 10;
                overflow = true;
            } else {
                newNode.val = digit;
            }

            node.next = newNode;
            node = node.next;

            l2 = l2.next;
        }

        if(overflow) {
            ListNode newNode = new ListNode(1);
            node.next = newNode;
        }

        return dummy.next;
    }
}

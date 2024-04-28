package problems;

import problems.util.ListNode;

public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        ListNode reversed = reverse(head);

        int max = Integer.MIN_VALUE;

        ListNode dummy = new ListNode(max, reversed);

        ListNode prev = dummy;
        ListNode curr = reversed;

        while(curr != null) {
            if(curr.val >= max) {
                max = curr.val;
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

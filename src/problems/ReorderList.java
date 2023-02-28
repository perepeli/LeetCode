package problems;

import problems.listnode.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfReversed = reverse(slow.next);
        slow.next = null;

        ListNode temp = head;

        while(temp != null && secondHalfReversed != null) {
            ListNode leftNext = temp.next;
            ListNode rightNext = secondHalfReversed.next;

            temp.next = secondHalfReversed;
            secondHalfReversed.next = leftNext;

            temp = leftNext;
            secondHalfReversed = rightNext;
        }

    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

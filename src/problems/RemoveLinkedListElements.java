package problems;

import problems.listnode.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;

        while(curr != null) {
            if(curr.val == val) {
                dummy.next = curr.next;
            } else {
                break;
            }
            curr = curr.next;
        }

        if(curr == null || curr.next == null) return dummy.next;

        ListNode prev = curr;
        curr = curr.next;

        while(curr != null) {
            ListNode next = curr.next;

            if(curr.val == val) prev.next = next;
            else prev = curr;

            curr = next;
        }
        return dummy.next;
    }
}

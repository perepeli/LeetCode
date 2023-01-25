package problems;

import problems.listnode.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = head.next;
        ListNode prev = head;

        while(node != null) {
            if(node.val == prev.val) {
                ListNode next = node.next;
                prev.next = next;
                node = next;
            } else {
                prev = prev.next;
                node = node.next;
            }
        }
        return head;
    }
}

package problems;

import problems.listnode.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        int counter = 0;

        while(fast != null) {
            if(fast == slow) return true;
            if(counter % 2 == 0) {
                slow = slow.next;
            }
            fast = fast.next;
            counter++;
        }
        return false;
    }
}

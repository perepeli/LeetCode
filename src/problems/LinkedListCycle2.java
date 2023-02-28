package problems;

import problems.listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if(hasCycle) {
            fast = slow;
            slow = head;

            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        return null;
    }
}

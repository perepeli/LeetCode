package problems;

import problems.listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode tempNode = head;
        Set<ListNode> set = new HashSet<>();

        while(tempNode != null) {
            if(!set.contains(tempNode)) {
                set.add(tempNode);
                tempNode = tempNode.next;
            } else {
                break;
            }
        }
        return tempNode;

    }
}

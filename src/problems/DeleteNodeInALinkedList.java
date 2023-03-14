package problems;

import problems.listnode.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node == null) return;

        ListNode next = node.next;
        if(next.next == null) {
            node.val = next.val;
            node.next = null;
        }
        ListNode nextNext = next.next;
        node.val = next.val;
        node.next = nextNext;
    }
}

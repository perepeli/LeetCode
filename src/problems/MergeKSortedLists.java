package problems;

import problems.listnode.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists) {
            if(node != null) heap.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            if(node.next != null) heap.offer(node.next);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}

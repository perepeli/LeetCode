package problems;

import problems.util.ListNode;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left >= right) return head;
        ListNode leftPrev = null;
        ListNode leftNode = head;
        int leftIndex = 1;

        while(leftIndex != left) {
            leftPrev = leftNode;
            leftNode = leftNode.next;
            leftIndex++;
        }

        int rightIndex = leftIndex;
        ListNode rightNode = leftNode;
        while(rightIndex != right) {
            rightNode = rightNode.next;
            rightIndex++;
        }
        ListNode rightNext = rightNode.next;

        ListNode prev = leftPrev;
        ListNode curr = leftNode;

        while(curr != rightNext) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        leftNode.next = rightNext;
        if(leftPrev == null) return prev;
        leftPrev.next = prev;

        return head;
    }
}

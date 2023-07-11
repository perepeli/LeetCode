package problems;

import problems.util.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode left = head;
        ListNode right = head.next;

        ListNode toReturn = right;

        while(left != null && right != null) {
            ListNode nextLeft = right.next;
            if(nextLeft == null) { // next left is not present
                right.next = left;
                left.next = null;
                break;
            }
            ListNode nextRight = right.next.next;
            if(nextRight == null) { // next left is present, but right is not

                right.next = left;
                left.next = nextLeft;
                break;
            }
            // both next are present

            right.next = left;
            left.next = nextRight;

            left = nextLeft;
            right = nextRight;
        }

        return toReturn;
    }
}

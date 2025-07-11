package problems;

import problems.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tempPrev = dummy;
        ListNode tempNext = dummy.next;

        while(tempNext != null) {
            if(set.contains(tempNext.val)) {
                tempPrev.next = tempNext.next;
                tempNext = tempPrev.next;
            } else {
                tempPrev = tempNext;
                tempNext = tempNext.next;
            }
        }

        return dummy.next;
    }
}

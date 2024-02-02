package problems;

import problems.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        int res = 0;

        while(head != null) {
            if(set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }

        return res;
    }
}

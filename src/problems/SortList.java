package problems;

import problems.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        ListNode temp = head;

        List<ListNode> list = new ArrayList<>();
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        Collections.sort(list, (a, b) -> a.val - b.val);

        for(int i = 1; i < list.size(); i++) {
            ListNode prev = list.get(i - 1);
            ListNode curr = list.get(i);
            prev.next = curr;
            curr.next = null;
        }

        return list.get(0);
    }
}

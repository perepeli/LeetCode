package problems;


import problems.util.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while(list1 != null && list2 != null) {
            ListNode curr = new ListNode();
            if(list1.val < list2.val) {
                curr.val = list1.val;
                list1 = list1.next;
            } else {
                curr.val = list2.val;
                list2 = list2.next;
            }
            temp.next = curr;
            temp = curr;
        }

        while(list1 != null) {
            ListNode curr = new ListNode(list1.val);
            list1 = list1.next;
            temp.next = curr;
            temp = curr;
        }

        while(list2 != null) {
            ListNode curr = new ListNode(list2.val);
            list2 = list2.next;
            temp.next = curr;
            temp = curr;
        }

        return dummy.next;
    }
}

package problems;


import problems.listnode.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rootToReturn = new ListNode();
        ListNode tempNode = rootToReturn;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tempNode.next = l1;
                l1 = l1.next;

            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;


        }

        if(l1 != null) {
            while (l1 != null) {
                tempNode.next = l1;
                l1 = l1.next;
                tempNode = tempNode.next;
            }
        }

        if(l2 != null) {
            while (l2 != null) {
                tempNode.next = l2;
                l2 = l2.next;
                tempNode = tempNode.next;
            }
        }

        return rootToReturn.next;
    }
}

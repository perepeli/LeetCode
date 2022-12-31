package problems;

import problems.listnode.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // 1->2->(3)->4->5 :ODD
        //0,0
        //1,1++
        //2,1
        //3,2++
        //4,2

        // 1->2->3->(4)->5->6 :EVEN -second middle
        //0,0
        //1,1++
        //2,1
        //3,2++
        //4,2
        //5,3++

        if(head == null) return null;

        ListNode tempNode = head;
        ListNode middle = head;

        int counter = 0;
        while(tempNode != null) {
            if(counter % 2 != 0) {
                middle = middle.next;
            }
            counter++;
            tempNode = tempNode.next;
        }
        return middle;




    }
}

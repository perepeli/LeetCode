package problems;

public class FlattenMultilevelDoublyLinkedList {

}

//class Solution {
//    public Node flatten(Node head) {
//        Node tempNode = head;
//        recursive(tempNode, false, null);
//        return head;
//    }
//
//    private void recursive(Node node, boolean wasChild, Node parent) {
//
//        if(node != null && node.child != null) { // has child
//            recursive(node.child, true, node);
//            node.next = node.child;
//            node.child.prev = node;
//            node.child = null;
//
//        }
//
//        if(node == null) return; // last one
//
//        if(wasChild && node.next == null) {
//            node.next = parent.next;
//            parent.next.prev = node;
//        } else {
//            recursive(node.next, wasChild, node);
//        }
//    }
//}

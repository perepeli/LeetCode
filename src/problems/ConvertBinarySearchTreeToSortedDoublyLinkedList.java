package problems;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node head;
    Node tail;
    Node temp;
    public Node treeToDoublyList(Node root) {
        head = null;
        tail = null;
        temp = null;
        dfs(root);

        if(head != null) head.left = tail;
        if(tail != null) tail.right = head;

        return head;
    }

    private void dfs(Node node) {
        if(node == null) return;
        dfs(node.left);

        if(head == null || node.val < head.val) head = node;
        if(tail == null || node.val > tail.val) tail = node;

        if(temp != null) temp.right = node;
        node.left = temp;
        temp = node;

        dfs(node.right);
    }
}

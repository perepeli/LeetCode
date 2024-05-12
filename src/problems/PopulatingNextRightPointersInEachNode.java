package problems;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(root);

        while(!q1.isEmpty() || !q2.isEmpty()) {
            if(!q1.isEmpty()) {
                Node prev = q1.poll();

                while(!q1.isEmpty()) {
                    Node next = q1.poll();
                    if(prev.left != null) q2.offer(prev.left);
                    if(prev.right != null) q2.offer(prev.right);
                    prev.next = next;
                    prev = next;
                }

                if(prev.left != null) q2.offer(prev.left);
                if(prev.right != null) q2.offer(prev.right);

            } else if(!q2.isEmpty()) {
                Node prev = q2.poll();

                while(!q2.isEmpty()) {
                    Node next = q2.poll();
                    if(prev.left != null) q1.offer(prev.left);
                    if(prev.right != null) q1.offer(prev.right);
                    prev.next = next;
                    prev = next;
                }

                if(prev.left != null) q1.offer(prev.left);
                if(prev.right != null) q1.offer(prev.right);
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

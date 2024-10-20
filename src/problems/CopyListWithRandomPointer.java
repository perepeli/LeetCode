package problems;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node temp = head;

        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        for(var entry : map.entrySet()) {
            Node original = entry.getKey();
            Node copy = entry.getValue();

            if(original.next != null) {
                copy.next = map.get(original.next);
            }

            if(original.random != null) {
                copy.random = map.get(original.random);
            }
        }

        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

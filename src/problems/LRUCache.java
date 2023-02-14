package problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    Map<Integer, DLinkedNode> cache = new HashMap<>();
    DLinkedNode head;
    DLinkedNode tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if(!cache.containsKey(key)) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);

            addNode(newNode);
            size++;

            if(size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }

        } else {
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(DLinkedNode node) { // (head) <-> () <-> ()
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

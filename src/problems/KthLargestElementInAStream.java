package problems;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> pq;
    int capacity;

    public KthLargestElementInAStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        capacity = k;

        for(int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if(pq.size() < capacity) {
            pq.offer(val);
        } else if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

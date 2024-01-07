package problems;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

        for(int i : nums) {
            if(pq.size() < k) {
                pq.add(i);
            } else {
                if(pq.peek() < i) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }

        return pq.peek();
    }
}

package problems;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int window;

    public KthLargestElementInAStream(int k, int[] nums) {
        window = k;

        for (int num : nums) {
            if (window > 0) {
                pq.offer(num);
                window--;
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
    }

    public int add(int val) {
        if(window  > 0) {
            pq.offer(val);
            window--;
        } else {
            if(val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
        }

        return pq.peek();
    }
}

package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);


        for(var e : map.entrySet()) {
            int[] elem = new int[]{e.getKey(), e.getValue()};

            if(k > 0) {
                pq.offer(elem);
                k--;
            } else {
                if(pq.peek()[1] < elem[1]) {
                    pq.poll();
                    pq.offer(elem);
                }
            }
        }

        int[] res = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()) {
            res[index++] = pq.poll()[0];
        }

        return res;
    }
}

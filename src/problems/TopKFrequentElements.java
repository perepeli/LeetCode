package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for(int i : nums) {
            frequency.putIfAbsent(i, 0);
            frequency.put(i, frequency.get(i) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> e : frequency.entrySet()) {
            if(pq.size() == k) {
                if(pq.peek().getValue() < e.getValue()) {
                    pq.poll();
                    pq.offer(e);
                }
            } else {
                pq.offer(e);
            }
        }

        int[] res = new int[k];

        while(k > 0) {
            res[res.length - k] = pq.poll().getKey();
            k--;
        }

        return res;
    }
}

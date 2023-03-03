package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        for(Map.Entry<Integer, Integer> e : map.entrySet()) pq.offer(e);

        int[] res = new int[k];
        int index = 0;

        while(k > 0) {
            res[index] = pq.poll().getKey();
            k--;
            index++;
        }

        return res;
    }
}

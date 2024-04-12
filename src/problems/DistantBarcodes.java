package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : barcodes) freq.put(i, freq.getOrDefault(i, 0) + 1);

        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[1] - p1[1]);

        for(Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        int[] res = new int[barcodes.length];
        int index = 0;
        while(!pq.isEmpty()) {
            int[] p1 = pq.poll();
            int[] p2 = pq.poll();

            p1[1]--;
            if(p2 != null) p2[1]--;

            res[index++] = p1[0];
            if(p2 != null) res[index++] = p2[0];

            if(p1[1] > 0) pq.offer(p1);
            if(p2 != null && p2[1] > 0) pq.offer(p2);
        }

        return res;
    }
}

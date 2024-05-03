package problems;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        for(int[] i : intervals) pq.offer(i);

        List<int[]> res = new ArrayList<>();

        while(!pq.isEmpty()) {
            int[] mergedInterval = pq.poll();
            while(!pq.isEmpty() && pq.peek()[0] <= mergedInterval[1]) {
                int[] interval = pq.poll();
                mergedInterval[1] = Math.max(mergedInterval[1], interval[1]);
            }
            res.add(mergedInterval);
        }

        int[][] resArray = new int[res.size()][2];

        for(int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}

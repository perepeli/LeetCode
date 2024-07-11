package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[0] - arr2[0]);

        for(int[] e : firstList) pq.offer(e);
        for(int[] e : secondList) pq.offer(e);

        List<int[]> res = new ArrayList<>();

        while(pq.size() > 1) {
            int[] left = pq.poll();
            int[] right = pq.peek();

            if(right[0] < left[1] && right[1] < left[1]) {
                res.add(pq.poll());
                pq.offer(left);
            } else if(right[0] < left[1]) {
                res.add(new int[]{right[0], left[1]});
            } else if(left[1] == right[0]) {
                res.add(new int[]{left[1], left[1]});
            } else {
                continue;
            }
        }

        int[][] resArray = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) resArray[i] = res.get(i);
        return resArray;
    }
}

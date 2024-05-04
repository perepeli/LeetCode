package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] - p1[0]);

        for(int i = 0; i < profits.length; i++) {
            pq.offer(new int[]{profits[i], capital[i]});
        }

        while(!pq.isEmpty() && k > 0) {
            int countBefore = pq.size();
            List<int[]> reinsert = new ArrayList<>();
            while(!pq.isEmpty()) {
                int[] current = pq.poll();
                if(current[1] <= w) {
                    w += current[0];
                    k--;
                    break;
                } else {
                    reinsert.add(current);
                }
            }

            if(reinsert.size() == countBefore) {
                return w;
            }

            for(int[] i : reinsert) pq.offer(i);
        }

        return w;
    }
}

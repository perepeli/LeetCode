package problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : amount) if(i > 0) pq.offer(i);

        int res = 0;

        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            res++;

            first--;
            second--;

            if(first > 0) pq.offer(first);
            if(second > 0) pq.offer(second);
        }

        if(!pq.isEmpty()) res += pq.poll();

        return res;
    }
}

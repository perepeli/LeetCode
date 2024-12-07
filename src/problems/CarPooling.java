package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int currentCapacity = 0;

        for(int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];

            while(!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                currentCapacity -= pq.poll()[0];
            }

            currentCapacity += trip[0];
            if(currentCapacity > capacity) return false;
            pq.offer(trip);
        }

        return true;
    }
}

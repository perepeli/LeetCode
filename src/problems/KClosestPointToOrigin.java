package problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>(
                (int[] p1, int[] p2) -> Double.compare(distance(p1), distance(p2)));

        for(int[] e: points) heap.add(new int[]{e[0], e[1]});

        int[][] out = new int[k][2];

        while(k > 0) {
            int[] p = heap.poll();
            out[k-1][0] = p[0];
            out[k-1][1] = p[1];
            k--;
        }

        return out;
    }

    private double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0] - 0, 2) + Math.pow(point[1] - 0, 2));
    }
}

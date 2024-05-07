package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++) cars[i] = new int[]{position[i], speed[i]};
        Arrays.sort(cars, (c1, c2) -> c1[0] - c2[0]);

        int res = 0;

        Deque<int[]> stack = new ArrayDeque<>();
        for(int[] i : cars) stack.addLast(i);

        while(!stack.isEmpty()) {
            int[] next = stack.removeLast();
            double nextTimeToTarget = (target - next[0]) / (double) next[1];

            while(!stack.isEmpty()) {
                int[] prev = stack.peekLast();
                double prevTimeToTarget = (target - prev[0]) / (double) prev[1];

                if(prevTimeToTarget <= nextTimeToTarget) {
                    stack.removeLast();
                } else {
                    break;
                }
            }

            res++;
        }

        return res;
    }
}

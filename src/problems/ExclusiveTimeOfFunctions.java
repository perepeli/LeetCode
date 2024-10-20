package problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Deque<int[]> deque = new ArrayDeque<>();

        for(String s : logs) {
            String[] parts = s.split(":");
            int functionId = Integer.parseInt(parts[0]);
            int start = "start".equals(parts[1]) ? 1 : 0;
            int timestamp = Integer.parseInt(parts[2]);

            if(start == 1) {
                deque.push(new int[]{functionId, timestamp});
            } else {
                int[] startElem = deque.pop();
                int time = timestamp - startElem[1] + 1;
                res[functionId] += time;

                if(!deque.isEmpty()) {
                    res[deque.peek()[0]] -= time;
                }
            }

        }

        return res;
    }
}

package problems;

import java.util.*;

public class DesignALeaderboard {
    Map<Integer, Integer> map;

    public DesignALeaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if(heap.size() > K) {
                heap.poll();
            }
        }

        int topK = 0;
        Iterator<Map.Entry<Integer, Integer>> values = heap.iterator();

        while(values.hasNext()) {
            topK += values.next().getValue();
        }

        return topK;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}

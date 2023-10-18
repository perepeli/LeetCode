package problems;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : tasks) map.put(ch, map.getOrDefault(ch, 0) + 1);

        int res = 0;

        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        map.entrySet().forEach(e -> pq.offer(e));

        while(!pq.isEmpty()) {
            int cooldown = n + 1;
            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
            int cd = cooldown;

            for(int i = 0; i < cd; i++) {
                if(pq.peek() == null || cooldown == 0) break;
                Map.Entry<Character, Integer> e = pq.poll();
                e.setValue(e.getValue() - 1);
                if(e.getValue() != 0) temp.add(e);
                res++;
                cooldown--;
            }
            temp.forEach(pq::offer);
            if (!pq.isEmpty()) res += cooldown;
        }

        return res;
    }
}

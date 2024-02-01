package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
        for(Map.Entry<Character, Integer> e : map.entrySet()) pq.offer(new int[]{e.getKey(), e.getValue()});

        int removals = 0;

        while(!pq.isEmpty() && pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            if(second[1] == first[1]) {
                second[1]--;
                removals++;
                if(second[1] != 0) pq.offer(second);
                pq.offer(first);
            } else {
                pq.offer(second);
            }
        }

        return removals;
    }
}

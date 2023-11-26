package problems;

import java.util.*;

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.getKey() - p2.getKey());

        for(var i : map.entrySet()) pq.offer(i);

        while(!pq.isEmpty()) {
            int consumed = 0;
            int currentVal = pq.peek().getKey() - 1;
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

            while(!pq.isEmpty()) {
                Map.Entry<Integer, Integer> e = pq.poll();
                int k = e.getKey();
                e.setValue(e.getValue() - 1);
                consumed++;

                currentVal++;
                if (currentVal != k) return false;

                if(e.getValue() != 0) list.add(e);
                if(consumed == groupSize) break;
            }
            if(consumed != groupSize) return false;

            for(var e : list) {
                pq.offer(e);
            }
        }

        return pq.isEmpty();
    }
}

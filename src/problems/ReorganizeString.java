package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        Queue<int[]> pq = new PriorityQueue<>((a1, a2) -> (a2[1] - a1[1]));
        for(Map.Entry<Character, Integer> e : map.entrySet()) pq.offer(new int[]{e.getKey(), e.getValue()});

        StringBuilder sb = new StringBuilder();

        int[] last = new int[]{'*', 0};

        while(!pq.isEmpty() && pq.size() > 1) {
            int[] first = pq.poll();
            if(first[0] != last[0]) {
                sb.append((char)(first[0]));
                first[1]--;
                last = first;
                System.out.println("X");
            } else {
                int[] second = pq.poll();
                sb.append((char)(second[0]));
                second[1]--;
                last = second;
                if(second[1] != 0) pq.offer(second);
            }

            if(first[1] != 0) pq.offer(first);
        }

        if(!pq.isEmpty() && (pq.peek()[0] == last[0] || pq.peek()[1] > 1)) return "";
        sb.append((char)(pq.poll()[0]));

        return sb.toString();
    }
}

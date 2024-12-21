package problems;

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for(int[] i : buildings) {
            events.add(new int[]{i[0], i[2], 1});
            events.add(new int[]{i[1], i[2], -1});
        }

        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[2] != b[2]) return b[2] - a[2];
            return a[2] == 1 ? b[1] - a[1] : a[1] - b[1];
        });


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> heightFreq = new HashMap<>();
        maxHeap.offer(0);
        heightFreq.put(0, 1);

        List<List<Integer>> result = new ArrayList<>();

        int maxHeight = 0;

        for(int[] i : events) {
            if(i[2] == 1) {
                heightFreq.put(i[1], heightFreq.getOrDefault(i[1], 0) + 1);
                if(heightFreq.get(i[1]) == 1) maxHeap.offer(i[1]);
            } else {
                heightFreq.put(i[1], heightFreq.get(i[1]) - 1);
                if(heightFreq.get(i[1]) == 0) heightFreq.remove(i[1]);
            }

            while(!maxHeap.isEmpty() && !heightFreq.containsKey(maxHeap.peek())) maxHeap.poll();

            if(maxHeight != maxHeap.peek()) {
                result.add(List.of(i[0], maxHeap.peek()));
                maxHeight = maxHeap.peek();
            }
        }
        return result;
    }
}

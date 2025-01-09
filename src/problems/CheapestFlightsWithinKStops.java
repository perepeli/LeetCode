package problems;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});  // cost, node, stops

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], node = current[1], stops = current[2];

            if (node == dst) return cost;

            if (stops > k || (visited.containsKey(node) && visited.get(node) <= stops)) {
                continue;
            }
            visited.put(node, stops);

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], price = neighbor[1];
                pq.offer(new int[]{cost + price, nextNode, stops + 1});
            }
        }
        return -1;
    }
}

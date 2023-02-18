package problems;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(edges, graph);

        int components = 0;

        Set<Integer> visited = new HashSet<>();

        for(Integer key : graph.keySet()) {
            if(visited.contains(key)) continue;
            components++;

            consumeComponent(graph, key, visited);
        }

        components += n - graph.keySet().size();

        return components;
    }

    private void consumeComponent(Map<Integer, List<Integer>> graph, Integer vertex, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);

        while(!queue.isEmpty()) {
            Integer current = queue.poll();
            if(visited.contains(current)) continue;
            visited.add(current);

            for(Integer child : graph.get(current)) {
                queue.offer(child);
            }
        }
    }



    private void buildGraph(int[][] edges, Map<Integer, List<Integer>> graph) {
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
        }
    }
}

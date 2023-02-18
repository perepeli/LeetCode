package problems;

import java.util.*;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);


        }

        boolean[] visited = new boolean[n];

        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            if(currNode == destination) {
                return true;
            }

            for(int nextNode: graph.get(currNode)) {
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        return false;
    }
}

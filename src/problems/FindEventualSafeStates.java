package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int node : graph[i]) {
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];

        while(!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for(int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}

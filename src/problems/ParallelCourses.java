package problems;

import java.util.*;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        if(n == 0) return 0;

        int[] inDegree = new int[n+1];
        List<List<Integer>> adjList = new ArrayList<>(n+1);

        for(int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] relation : relations) {
            adjList.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }

        int maxDepth = 0;
        int visited = 0;
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        for(int i = 1; i < n + 1; i++) {
            if(inDegree[i] == 0) queue.add(new AbstractMap.SimpleEntry<>(i, 1));
        }

        while(!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> p = queue.poll();
            int node = p.getKey();
            int depth = p.getValue();

            visited++;
            maxDepth = Math.max(maxDepth, depth);

            for(int neighbour : adjList.get(node)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) queue.offer(new AbstractMap.SimpleEntry<>(neighbour, depth + 1));
            }
        }

        if(visited < adjList.size()-1) return -1;

        return maxDepth;
    }
}

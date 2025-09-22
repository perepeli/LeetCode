package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];

            adjList.putIfAbsent(from, new HashSet<>());
            adjList.putIfAbsent(to, new HashSet<>());

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        int max = 0;

        for(int i = 0; i < n; i++) {
            if(!adjList.containsKey(i)) continue;
            for(int j = i + 1; j < n; j++) {
                if(!adjList.containsKey(j)) continue;

                int temp = adjList.get(i).size() + adjList.get(j).size();
                if(adjList.get(i).contains(j) && adjList.get(j).contains(i)) temp--;

                max = Math.max(max, temp);
            }
        }

        return max;
    }
}

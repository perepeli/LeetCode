package problems;

import java.util.HashSet;
import java.util.Set;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> setOdd = new HashSet<>();
        Set<Integer> setEven = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        boolean[] res = new boolean[]{true};

        for(int i = 0; i < graph.length; i++) {
            if(!visited.contains(i)) {
                dfs(graph, i, setOdd, setEven, visited, true, res);
            }
        }

        return res[0];
    }

    private void dfs(int[][] graph, int index, Set<Integer> setOdd, Set<Integer> setEven, Set<Integer> visited, boolean isOdd, boolean[] res) {
        if(!res[0]) return;

        if(isOdd) {
            if(setEven.contains(index)) {
                res[0] = false;
                return;
            } else {
                setOdd.add(index);
            }
        } else {
            if(setOdd.contains(index)) {
                res[0] = false;
                return;
            } else {
                setEven.add(index);
            }
        }

        if(!visited.contains(index)) {
            visited.add(index);

            for(int i : graph[index]) {
                dfs(graph, i, setOdd, setEven, visited, !isOdd, res);
            }
        }
    }
}

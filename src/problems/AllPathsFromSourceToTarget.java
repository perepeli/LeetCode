package problems;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(graph[0].length > 0) temp.add(0);
        backtrack(graph, 0, temp, res);
        return res;
    }


    private void backtrack(int[][] graph, int r, List<Integer> temp, List<List<Integer>> res) {
        if(r == graph.length - 1) {
            res.add(new ArrayList<>(temp));
        } else {
            for(int i : graph[r]) {
                temp.add(i);
                backtrack(graph, i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

package problems;

import problems.util.Pair;

import java.util.*;

public class PacificAtlanticWaterFlow {
    private static final int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer, Integer>> pacific = new HashSet<>();
        Set<Pair<Integer, Integer>> atlantic = new HashSet<>();

        for (int i = 0; i < heights[0].length; i++) dfs(0, i, heights, heights[0][i], pacific);
        for (int i = 0; i < heights.length; i++) dfs(i, 0, heights, heights[i][0], pacific);

        for (int i = 0; i < heights[0].length; i++) dfs(heights.length - 1, i, heights, heights[heights.length - 1][i], atlantic);
        for (int i = 0; i < heights.length; i++) dfs(i, heights[0].length - 1, heights, heights[i][heights[0].length - 1], atlantic);

        List<List<Integer>> res = new ArrayList<>();

        for(Pair<Integer, Integer> p : pacific) {
            if(atlantic.contains(p)) {
                res.add(List.of(p.getKey(), p.getValue()));
            }
        }

        return res;
    }

    private void dfs(int r, int c, int[][] arr, int fromHeight, Set<Pair<Integer, Integer>> set) {
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length) return;
        if(fromHeight > arr[r][c]) return;

        Pair<Integer, Integer> p = new Pair<>(r, c);
        if(set.contains(p)) return;
        set.add(p);

        for(int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], arr, arr[r][c], set);
        }
    }
}

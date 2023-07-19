package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int[][] landHeights;
    int R;
    int C;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0 || heights[0].length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        landHeights = heights;
        R = heights.length;
        C = heights[0].length;

        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for(int r = 0; r < R; r++) {
            pacificQ.offer(new int[]{r,0});
            atlanticQ.offer(new int[]{r,C-1});
        }

        for(int c = 0; c < C; c++) {
            pacificQ.offer(new int[]{0,c});
            atlanticQ.offer(new int[]{R-1,c});
        }

        boolean[][] pacific = bfs(pacificQ);
        boolean[][] atlantic = bfs(atlanticQ);

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(pacific[r][c] && atlantic[r][c]) res.add(List.of(r, c));
            }
        }

        return res;
    }

    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[R][C];

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            reachable[cell[0]][cell[1]] = true;
            for(int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if(newRow < 0 || newRow >= R || newCol < 0 || newCol >= C) continue;

                if(reachable[newRow][newCol]) continue;

                if(landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) continue;
                queue.offer(new int[]{newRow, newCol});
            }
        }

        return reachable;
    }
}

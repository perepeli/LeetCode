package problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int EMPTY = 0;
        int FRESH = 1;
        int ROTTEN = 2;

        int[][] directions = new int[][]{{0,-1},{-1,0},{0,+1},{1,0}};
        int R = grid.length;
        int C = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == ROTTEN) {
                    queue.offer(new int[]{r,c,0});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int depth = cell[2];

            int state = grid[r][c];

            if(state == EMPTY) continue;

            if(state == FRESH) res = Math.max(res, depth);

            for(int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                int newDepth = depth + 1;

                if(newR < 0 || newC < 0 || newR >= R || newC >= C) continue;

                if(grid[newR][newC] != FRESH) continue;

                queue.add(new int[]{newR, newC, newDepth});

            }

            grid[r][c] = EMPTY;
        }

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == FRESH) return -1;
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }
}

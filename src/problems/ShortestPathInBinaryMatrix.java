package problems;

import problems.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int R = grid.length;
        int C = grid[0].length;

        int[][] directions = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        boolean[][] visited = new boolean[R][C];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;


        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int distance = node[2];

            if(row == R-1 && col == C-1) return distance;

            for (int[] direction : directions) {
                int r = row + direction[0];
                int c = col + direction[1];

                if(r < 0 || c < 0) continue;
                if(r >= R || c >= C) continue;


                if(!visited[r][c] && (grid[r][c] != 1)) {
                    queue.offer(new int[]{r,c,distance+1});
                    visited[r][c] = true;
                }
            }
        }
        return -1;
    }
}

package problems;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfThereIsAValidPathInAGrid {
    int[] LEFT = {0, -1};
    int[] RIGHT = {0, 1};
    int[] UP = {-1, 0};
    int[] DOWN = {1, 0};

    int[][][] dir = {
            {LEFT, RIGHT},
            {UP, DOWN},
            {LEFT, DOWN},
            {DOWN, RIGHT},
            {LEFT, UP},
            {UP, RIGHT}
    };

    public boolean hasValidPath(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int n = grid[r][c] - 1;

            for(int[] next : dir[n]) {
                int newR = r + next[0];
                int newC = c + next[1];

                if(newR < 0 || newC < 0 || newR >= M || newC >= N || visited[newR][newC]) continue;

                for(int[] back : dir[grid[newR][newC] - 1]) {
                    if(newR + back[0] == r && newC + back[1] == c) {
                        visited[newR][newC] = true;
                        queue.offer(new int[]{newR, newC});
                    }
                }
            }
        }

        return visited[M - 1][N - 1];
    }
}

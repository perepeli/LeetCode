package problems;

import java.util.Deque;
import java.util.LinkedList;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int M = maze.length;
        int N = maze[0].length;

        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];

        queue.offer(new int[]{entrance[0], entrance[1], 0});

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            int depth = node[2];
            int nextDepth = depth + 1;

            if(!valid(M, N, r, c)) continue;
            if(visited[r][c]) continue;
            else visited[r][c] = true;

            if(maze[r][c] == '.') {
                if(!(r == entrance[0] && c == entrance[1])) {
                    if(r == 0 || c == 0 || r == M - 1 || c == N - 1) {
                        return depth;
                    }
                }

                queue.offer(new int[]{r + 1, c, nextDepth});
                queue.offer(new int[]{r - 1, c, nextDepth});
                queue.offer(new int[]{r, c + 1, nextDepth});
                queue.offer(new int[]{r, c - 1, nextDepth});
            }
        }

        return -1;
    }

    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}

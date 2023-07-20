package problems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        int R = board.length;
        int C = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < R; r++) {
            if(board[r][0] == 'O') queue.offer(new int[]{r, 0});
            if(board[r][C-1] == 'O') queue.offer(new int[]{r, C-1});
        }

        for(int c = 0; c < C; c++) {
            if(board[0][c] == 'O') queue.offer(new int[]{0, c});
            if(board[R-1][c] == 'O') queue.offer(new int[]{R-1, c});
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if(r < 0 || c < 0 || r >= R || c >= C) continue;
            if(board[r][c] != 'O') continue;
            board[r][c] = 'Z';

            for(int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];
                queue.offer(new int[]{newR, newC});
            }
        }

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'Z') board[r][c] = 'O';
            }
        }
    }
}

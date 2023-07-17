package problems;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final int[][] DIRECTIONS = {{-1,0},{0,1},{0,-1},{1,0}};

    public void wallsAndGates(int[][] rooms) {
        int numR = rooms.length;
        int numC = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < numR; i++) {
            for(int j = 0; j < numC; j++) {
                if(rooms[i][j] == GATE) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if(r < 0 || c < 0 || r >= numR || c >= numC || rooms[r][c] != EMPTY) continue;
                rooms[r][c] = rooms[row][col] + 1;
                q.offer(new int[]{r,c});
            }
        }
    }
}

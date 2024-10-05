package problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ZeroOneMatrix {
    private static final int[][] DIR = {{0,1},{0,-1},{1,0},{-1,0}};

    public static int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] seen = new boolean[mat.length][mat[0].length];
        Deque<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) queue.addLast(new int[]{i, j, 0});
            }
        }
        while(!queue.isEmpty()) {
            int[] cell = queue.removeFirst();
            if(seen[cell[0]][cell[1]]) continue;
            seen[cell[0]][cell[1]] = true;
            res[cell[0]][cell[1]] = cell[2];

            for(int[] dir : DIR) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];
                if(newR >= 0 && newR < mat.length && newC >= 0 && newC < mat[0].length) {

                    queue.addLast(new int[]{newR, newC, cell[2] + 1});
                }

            }
        }
        return res;
    }
}

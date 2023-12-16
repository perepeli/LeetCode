package problems;

import java.util.ArrayList;
import java.util.List;

public class TheKnightsTour {
    private final int[][] DIRS = {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2}
    };

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        boolean[][] board = new boolean[m][n];
        List<int[]> res = new ArrayList<>();

        backtrack(r, c, m, n, board, new ArrayList<>(), res);

        int[][] result = new int[m][n];
        int counter = 0;
        for(int[] step : res) {
            result[step[0]][step[1]] = counter;
            counter++;
        }

        return result;
    }

    private void backtrack(int i, int j, int m, int n, boolean[][] board, List<int[]> temp, List<int[]> res) {
        if(res.size() > 0) return;
        if(temp.size() == m * n) {
            res.addAll(temp);
        } else {
            if(i >= 0 && i < m && j >= 0 && j < n && !board[i][j] && res.size() == 0) {
                for(int[] dir : DIRS) {
                    board[i][j] = true;
                    temp.add(new int[]{i, j});

                    backtrack(i + dir[0], j + dir[1], m, n, board, temp, res);

                    temp.remove(temp.size() - 1);
                    board[i][j] = false;

                }
            }
        }
    }
}

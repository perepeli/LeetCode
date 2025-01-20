package problems;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] rowDp = new int[M][N];
        int[][] colDp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        rowDp[i][j]++;
                    }
                    if (j > 0) {
                        rowDp[i][j] += rowDp[i][j - 1];
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] != 'W') {
                    if (j < N - 1 && grid[i][j + 1] != 'W') {
                        rowDp[i][j] = rowDp[i][j + 1];
                    }
                }
            }
        }

        for (int c = 0; c < N; c++) {
            for (int r = 0; r < M; r++) {
                if (grid[r][c] != 'W') {
                    if (grid[r][c] == 'E') {
                        colDp[r][c]++;
                    }
                    if (r > 0) {
                        colDp[r][c] += colDp[r - 1][c];
                    }
                }
            }
        }

        for (int c = 0; c < N; c++) {
            for (int r = M - 1; r >= 0; r--) {
                if (grid[r][c] != 'W') {
                    if (r < M - 1 && grid[r + 1][c] != 'W') {
                        colDp[r][c] = colDp[r + 1][c];
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == '0') {
                    int killed = rowDp[i][j] + colDp[i][j];
                    max = Math.max(max, killed);
                }
            }
        }

        return max;
    }
}

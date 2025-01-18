package problems;

public class MaximumNumberOfMovesInAGrid {
    public int maxMoves(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];

        for(int c = N - 1; c >= 0; c--) {
            for(int r = M - 1; r >= 0; r--) {
                int upDiagonal = valid(M, N, r - 1, c + 1) ? (grid[r][c] < grid[r - 1][c + 1] ?1 + dp[r - 1][c + 1] : 0) : 0;
                int right = valid(M, N, r, c + 1) ? (grid[r][c] < grid[r][c + 1] ? 1 + dp[r][c + 1] : 0) : 0;
                int downDiagonal = valid(M, N, r + 1, c + 1) ? (grid[r][c] < grid[r + 1][c + 1] ? 1 + dp[r + 1][c + 1] : 0) : 0;

                int maxMoves = Math.max(upDiagonal, Math.max(right, downDiagonal));
                dp[r][c] = maxMoves;
            }
        }

        int max = 0;

        for(int[] i : dp) {
            max = Math.max(max, i[0]);
        }

        return max;
    }

    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}

package problems;

public class MaximumNumberOfFishInAGrid {
    private final int[][] DIR = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int findMaxFish(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        boolean[][] visited = new boolean[M][N];

        int res = 0;

        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(grid[r][c] > 0) {
                    res = Math.max(res, dfs(grid, visited, r, c, M, N));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c, int m, int n) {
        if(r < 0 || c < 0 || r >= m || c >= n) return 0;
        if(visited[r][c]) return 0;
        visited[r][c] = true;
        if(grid[r][c] == 0) return 0;

        int res = grid[r][c];

        for(int[] dir : DIR) {
            res += dfs(grid, visited, r + dir[0], c + dir[1], m, n);
        }

        return res;
    }
}

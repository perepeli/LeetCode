package problems;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int[] res = new int[]{0};
        backtrack(grid, res);
        return res[0];
    }

    private void backtrack(int[][] grid, int[] res) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int[] tmp = new int[]{0};
                dfs(grid, i, j, 0, tmp);
                res[0] = Math.max(res[0], tmp[0]);
            }
        }
    }

    private void dfs(int[][] grid, int row, int col, int temp, int[] res) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            res[0] = Math.max(res[0], temp);
        } else {
            int oldVal = grid[row][col];
            grid[row][col] = 0;
            dfs(grid, row + 1, col, temp + oldVal, res);
            dfs(grid, row - 1, col, temp + oldVal, res);
            dfs(grid, row, col + 1, temp + oldVal, res);
            dfs(grid, row, col - 1, temp + oldVal, res);
            grid[row][col] = oldVal;
        }
    }
}

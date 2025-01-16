package problems;

public class MinimumOperationsToMakeColumnsStrictlyIncreasing {
    public int minimumOperations(int[][] grid) {
        int res = 0;

        for(int i = 1; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] <= grid[i - 1][j]) {
                    int newNum = grid[i - 1][j] - grid[i][j] + 1;
                    res += newNum;
                    grid[i][j] += newNum;
                }
            }
        }

        return res;
    }
}

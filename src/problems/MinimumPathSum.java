package problems;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //return recursive(grid, 0, 0); // (brute force recursive solution)

        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = grid.length-1; i >= 0; i--) {
            for(int j = grid[0].length-1; j >= 0; j--) {
                //System.out.println(i + ":" + j);
                if(i == grid.length-1 && j == grid[0].length-1) { // bottom right (only once)
                    dp[i][j] = grid[i][j];
                } else if(i == grid.length-1) { // bottom row (nothing below)
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if(j == grid[0].length-1) { // right column (nothing right)
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else { // both below and right are present
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        // for(int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return dp[0][0];
    }

    private int recursive(int[][] arr, int row, int col) {
        if(row > arr.length-1 || col > arr[0].length-1) return Integer.MAX_VALUE;
        if(row == arr.length-1 && col == arr[0].length-1) return arr[row][col];

        return arr[row][col] + Math.min(recursive(arr, row+1, col), recursive(arr, row, col+1));
    }
}

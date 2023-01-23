package problems;

public class UniquePaths {
    public int uniquePaths(int row, int column) {
        int[][] dp = new int[row][column];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < column; j++) {
                if(i == 0) dp[i][j] = 1; // first row (only one way)
                else if(j == 0) dp[i][j] = dp[i-1][j]; // first column (have only top)
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];// normal case (have both top and left)
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}

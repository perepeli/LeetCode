package problems;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;

        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[0].length - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
        }

        return max;
    }
}

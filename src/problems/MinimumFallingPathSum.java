package problems;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int[][] dp = new int[rowLength][colLength];
        for(int i = 0; i < colLength; i++) dp[0][i] = matrix[0][i];


        for(int i = 1; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(j == 0) { // first col index (has only top-right)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == colLength-1) { // last col index (has only top-left)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else { // somewhere in the middle (has both top-left and top-right)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }

        //for(int[] e: dp) System.out.println(Arrays.toString(e));
        int min = Integer.MAX_VALUE;
        for(int e : dp[rowLength-1]) min = Math.min(e, min);

        return min;
    }
}

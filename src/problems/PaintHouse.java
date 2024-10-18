package problems;

public class PaintHouse {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];

        dp[costs.length - 1][0] = costs[costs.length - 1][0];
        dp[costs.length - 1][1] = costs[costs.length - 1][1];
        dp[costs.length - 1][2] = costs[costs.length - 1][2];

        for(int i = costs.length - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

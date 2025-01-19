package problems;

public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int[][] dp = new int[values.length][2];
        dp[values.length - 1][0] = values[values.length - 1];
        dp[values.length - 1][1] = values.length - 1;

        int max = 0;

        for(int i = values.length - 2; i >= 0; i--) {
            int tempMax = values[i] + dp[i + 1][0] - (dp[i + 1][1] - i);
            max = Math.max(max, tempMax);

            if(values[i] > dp[i + 1][0] - (dp[i + 1][1] - i)) {
                dp[i][0] = values[i];
                dp[i][1] = i;
            } else {
                dp[i][0] = dp[i + 1][0];
                dp[i][1] = dp[i + 1][1];
            }
        }

        return max;
    }
}

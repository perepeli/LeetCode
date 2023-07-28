package problems;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp[i] = 1;
            } else if(i == 1) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i-2] + dp[i-1];
            }
        }

        return dp[n-1];
    }
}

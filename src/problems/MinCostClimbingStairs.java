package problems;

import java.util.Map;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        for(int i = cost.length - 1; i >= 0; i--) {
            if(i == cost.length - 1) dp[i] = cost[i];
            else if(i == cost.length - 2) dp[i] = Math.min(cost[i], cost[i] + cost[i + 1]);
            else dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);

        //return Math.min(recursive(cost, 0), recursive(cost, 1));
    }

    private int recursive(int[] cost, int index) {
        if(index == cost.length - 1) return cost[index];
        else if(index == cost.length - 2) return Math.min(cost[index], cost[index] + cost[index + 1]);
        else return Math.min(cost[index] + recursive(cost, index + 1), cost[index] + recursive(cost, index + 2));
    }
}

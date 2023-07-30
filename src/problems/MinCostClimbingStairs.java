package problems;

public class MinCostClimbingStairs {
    ublic int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if(length <= 1) return 0;

        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(length-1, cost[length-1]);
        // map.put(length-2, cost[length-2]);
        // minCostMemoizationDP(-1, length, cost, map);
        // return map.get(-1);

        return minCostTabulationDP(length, cost);
    }

    private int minCostMemoizationDP(int p, int n, int[] cost, Map<Integer, Integer> dp) {
        if(!dp.containsKey(p)) dp.put(p, (p == -1 ? 0 : cost[p]) + Math.min(minCostMemoizationDP(p+1, n, cost, dp), minCostMemoizationDP(p+2, n, cost, dp)));
        return dp.get(p);
    }

    private int minCostTabulationDP(int n, int[] cost) {
        int[] dp = new int[n+1];
        dp[n] = cost[n-1];
        dp[n-1] = cost[n-2];
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = (i == 0 ? 0 : cost[i-1]) + Math.min(dp[i+1], dp[i+2]);
        }
        return dp[0];
    }
}

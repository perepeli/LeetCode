package problems;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 0) return 0;

        //Map<Integer, Integer> map = new HashMap<>();
        //map.put(n, 1);
        //climbStairsMemoizationDP(0, n, map);
        //return map.get(0);

        return climbStairsTabulationDP(n);
    }


    private int climbStairsMemoizationDP(int p, int n, Map<Integer, Integer> dp) {
        if(p > n) return 0;
        if(!dp.containsKey(p)) dp.put(p, climbStairsMemoizationDP(p+1, n, dp) + climbStairsMemoizationDP(p+2, n, dp));
        return dp.get(p);
    }

    private int climbStairsTabulationDP(int n) {
        int[] dp = new int[n+1];
        for(int i = n; i >= 0; i--) {
            if(i == n || i == n - 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i+1] + dp[i + 2];
            }
        }
        return dp[0];
    }
}

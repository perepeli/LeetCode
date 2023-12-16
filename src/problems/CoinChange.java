package problems;

import java.util.Arrays;

public class CoinChange {
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        //memo = new Integer[amount + 1];
        //return recursiveHelper(coins, amount);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <  dp.length; i++) {
            for(int j : coins) {
                int prev = i - j;
                if(prev < 0) continue;
                if(dp[prev] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], 1 + dp[prev]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    private int recursiveHelper(int[] coins, int remain) {
        if(remain < 0) return -1;
        if(remain == 0) return 0;

        if(memo[remain] != null) return memo[remain];

        int minCount = Integer.MAX_VALUE;

        for(int coin : coins) {
            int count = recursiveHelper(coins, remain - coin);
            if(count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }

        memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[remain];
    }
}

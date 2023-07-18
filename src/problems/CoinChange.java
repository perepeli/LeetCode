package problems;

public class CoinChange {
    private Integer[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount + 1];
        return recursive(coins, amount);
    }

    private int recursive(int[] coins, int remain) {
        if(remain < 0) return -1;
        if(remain == 0) return 0;

        if(dp[remain] != null) return dp[remain];

        int minCount = Integer.MAX_VALUE;
        for(int coin : coins) {
            int count = recursive(coins, remain - coin);
            if(count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }
        dp[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return dp[remain];
    }
}

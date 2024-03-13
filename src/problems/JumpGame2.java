package problems;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];

        dp[nums.length - 1] = 0;

        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if(dp[j] != null) {
                    dp[i] = (dp[i] == null ? 1 + dp[j] : Math.min(dp[i], 1 + dp[j]));
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0] == null ? -1 : dp[0];
    }
}

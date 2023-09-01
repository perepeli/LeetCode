package problems;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = nums.length-2; i >= 0; i--) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}

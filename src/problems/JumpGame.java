package problems;

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) dp[i] = true;
            else {
                for(int j = i; j <= i + nums[i]  && j < nums.length; j++) {
                    if(dp[j] == true) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}

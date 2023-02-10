package problems;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        boolean[] dp = new boolean[len];
        dp[len-1] = true;

        for(int i = len-1; i >= 0; i--) {
            int counter = nums[i];
            for(int j = i+1; j < len && counter > 0; j++) {
                if(dp[j] == true) {
                    dp[i] = true;
                    break;
                }
                counter--;
            }
        }
        return dp[0];
    }
}

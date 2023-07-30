package problems;

import java.util.Map;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];

        //Map<Integer, Integer> map = new HashMap<>();
        //robMemoizationDP(-1, nums.length, nums, map);
        //robMemoizationDP(0, nums.length, nums,map);
        //return Math.max(map.get(-1), map.get(0));

        return robTabulationDP(nums);
    }

    private int robMemoizationDP(int p, int n, int[] nums, Map<Integer, Integer> dp) {
        if(p >= n) return 0;
        if(!dp.containsKey(p)) dp.put(p, (p == -1 ? 0 : nums[p]) + Math.max(robMemoizationDP(p+2, n, nums, dp), robMemoizationDP(p+3, n, nums, dp)));
        return dp.get(p);
    }

    private int robTabulationDP(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[length-1] = nums[length-1];
        dp[length-2] = nums[length-2];

        for(int i = length-3; i >= 0; i--) {
            dp[i] = nums[i] + Math.max((i+2 < length ? dp[i+2] : 0), (i+3 < length ? dp[i+3] : 0));
        }

        return Math.max(dp[0], dp[1]);
    }
}

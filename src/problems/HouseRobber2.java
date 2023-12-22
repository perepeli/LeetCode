package problems;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] nums1 = new int[nums.length - 1]; // skip first
        int[] nums2 = new int[nums.length - 1]; // skip last

        for(int i = 1; i < nums.length; i++) {
            nums1[i - 1] = nums[i];
        }

        for(int i = 0; i < nums.length - 1; i++) {
            nums2[i] = nums[i];
        }

        return Math.max(robInternal(nums1), robInternal(nums2));
    }

    public int robInternal(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) dp[i] = nums[i];
            else if(i == nums.length - 2) dp[i] = Math.max(nums[i], nums[i + 1]);
            else dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return Math.max(dp[0], dp[1]);
    }
}

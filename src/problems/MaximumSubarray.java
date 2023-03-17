package problems;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            tempSum = Math.max(tempSum + nums[i], nums[i]);
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;
    }
}

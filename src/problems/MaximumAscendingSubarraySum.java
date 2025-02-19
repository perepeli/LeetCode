package problems;

public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];

        int temp = max;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}

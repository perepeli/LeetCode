package problems;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int minSubarrayLength = Integer.MAX_VALUE;
        int subarraySum = 0;

        while(right < nums.length) {
            subarraySum += nums[right];
            right++;

            while(subarraySum >= target) {
                minSubarrayLength = Math.min(minSubarrayLength, right - left);
                subarraySum -= nums[left];
                left++;
            }

        }

        return minSubarrayLength == Integer.MAX_VALUE ? 0 : minSubarrayLength;
    }
}

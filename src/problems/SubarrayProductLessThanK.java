package problems;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;

        int left = 0;
        int right = 0;

        while(right < nums.length) {
            product *= nums[right];

            while(product >= k) {
                product /= nums[left++];
            }

            totalCount += right - left + 1;

            right++;
        }

        return totalCount;
    }
}

package problems;

public class LeftAndRightSumDifferences {
    public int[] leftRightDifference(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prefix[i] = prefixSum;
            prefixSum += nums[i];
        }

        int suffixSum = 0;

        for(int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = suffixSum;
            suffixSum += nums[i];
        }

        for(int i = 0; i < res.length; i++) {
            res[i] = Math.abs(prefix[i] - suffix[i]);
        }
        return res;
    }
}

package problems;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int res = 0;

        for(int i = 1; i < nums.length; i++) {
            res = Math.max(res, Math.abs(nums[i] - nums[i - 1]));
        }

        res = Math.max(res, Math.abs(nums[0] - nums[nums.length - 1]));

        return res;
    }
}

package problems;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[]{0};
        backtrack(nums, 0, target, 0, res);
        return res[0];
    }

    private void backtrack(int[] nums, int index, int target, int sum, int[] res) {
        if (index == nums.length) {
            if(sum == target) res[0] += 1;
        } else {
            backtrack(nums, index + 1, target, sum + nums[index], res);

            backtrack(nums, index + 1, target, sum - nums[index], res);
        }
    }
}

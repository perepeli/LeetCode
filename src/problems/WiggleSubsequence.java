package problems;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        return 1 + Math.max(recursive(nums, 0, true), recursive(nums, 0, false));
    }

    private int recursive(int[] nums, int index, boolean isUp) {
        int res = 0;

        for(int i = index + 1; i < nums.length; i++) {
            if((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index])) {
                res = Math.max(res, 1 + recursive(nums, i, !isUp));
            }
        }

        return res;
    }
}

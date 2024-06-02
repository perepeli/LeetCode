package problems;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int res = 0;

        int length = 0;
        for(int i = 0; i < nums.length; i++) {
            prefix[i] = length;
            if(nums[i] == 1) length++;
            else length = 0;
        }
        length = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = length;
            if(nums[i] == 1) length++;
            else length = 0;
        }

        for(int i = 0; i < nums.length; i++) {
            res = Math.max(res, prefix[i] + suffix[i]);
        }

        return res;
    }
}

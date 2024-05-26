package problems;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int res = 0;

        while(left < right) {
            int num = nums[left] + nums[right];

            if(num == k) {
                res++;
                left++;
                right--;
            } else if(num > k) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}

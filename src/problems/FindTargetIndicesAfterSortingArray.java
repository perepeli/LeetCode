package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int firstIndex = left;

        if(nums[firstIndex] != target) return res;

        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        int lastIndex = left;

        for(int i = firstIndex; i <= lastIndex; i++) res.add(i);

        return res;

    }
}

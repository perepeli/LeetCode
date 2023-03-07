package problems;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);

        if(leftIndex == -1) return new int[]{-1, -1};
        return new int[]{leftIndex, rightIndex};
    }

    private int binarySearch(int[] nums, int target, boolean leftBias) {
        int left = 0;
        int right = nums.length-1;

        int res = -1;

        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                res = middle;
                if(leftBias) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return res;
    }
}

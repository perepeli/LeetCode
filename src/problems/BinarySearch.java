package problems;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(right-left > 1) {
            int middle = left+((right-left)/2);
            if(nums[middle] == target) return middle;

            if(target > nums[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if(nums[left] == target) return left;
        if(nums[right] == target) return right;

        return -1;
    }
}

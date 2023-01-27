package problems;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;


        while(true) {
            if(nums[left] < nums[right]) return nums[left];
            int middle = (left + right) / 2;
            if(left == middle) break;

            if(nums[middle] > nums[0]) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}

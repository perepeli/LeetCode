package problems;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        if(nums.length < 3) return true;

        int count = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i]) continue;

            if(i - 2 >= 0 && nums[i] <= nums[i - 2]) {
                count++;
                if(count == 2) return false;
                nums[i] = nums[i - 1];
                continue;
            } else {
                count++;
                if(count == 2) return false;
            }
        }

        return true;
    }
}

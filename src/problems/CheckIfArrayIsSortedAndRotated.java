package problems;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int inconsistencyCount = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                inconsistencyCount++;
                if(inconsistencyCount > 1) return false;
            }
        }

        if(inconsistencyCount == 1) {
            if(nums[nums.length - 1] > nums[0]) return false;
        }

        return true;
    }
}

package problems;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int missing = 0;

        for(int i = 0; i < nums.length; i++) {
            if(missing != nums[i]) return missing;
            missing++;
        }
        return missing;
    }
}

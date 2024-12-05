package problems;

import java.util.Arrays;

public class RearrangeArrayToMaximizePrefixScore {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);

        long score = 0;
        int count = 0;

        for(int i = nums.length - 1; i >= 0; i--) {
            long tempScore = score + nums[i];

            if(tempScore < 1) break;
            score = tempScore;
            count++;
        }

        return count;
    }
}

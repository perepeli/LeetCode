package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) { // set O(n)
        Set<Integer> set = new HashSet<>();

        for(int i : nums) set.add(i);

        int longestStreak = 0;

        for(int i : set) {
            if(set.contains(i - 1)) continue;

            int current = i;
            int tempStreak = 1;

            while(set.contains(current + 1)) {
                current++;
                tempStreak++;
            }

            longestStreak = Math.max(longestStreak, tempStreak);
        }

        return longestStreak;
    }

    // public int longestConsecutive(int[] nums) { // sorting O(nlogn)
    //     if(nums.length == 0) return 0;
    //     Arrays.sort(nums);

    //     int longestSequence = 1;
    //     int tempSequense = 1;

    //     for(int i = 1; i < nums.length; i++) {
    //         if(nums[i] == nums[i - 1]) continue;

    //         if(nums[i] == nums[i - 1] + 1) {
    //             tempSequense++;
    //             longestSequence = Math.max(longestSequence, tempSequense);
    //         } else {
    //             tempSequense = 1;
    //         }
    //     }
    //     return longestSequence;
    // }
}

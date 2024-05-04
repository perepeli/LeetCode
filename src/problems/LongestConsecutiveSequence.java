package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for(int i : set) {
            if(set.contains(i - 1)) continue;
            int tempLength = 1;
            int tempNum = i + 1;
            while(set.contains(tempNum)) {
                tempLength++;
                tempNum++;
            }
            longest = Math.max(longest, tempLength);
        }

        return longest;
    }
}

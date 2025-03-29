package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int res = 0;

        for(int i : set) {
            if(set.contains(i - 1)) continue;

            int length = 1;
            while(set.contains(++i)) length++;

            res = Math.max(res, length);
        }


        return res;
    }
}

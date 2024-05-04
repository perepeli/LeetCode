package problems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int index = 0;
        while(index < nums.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[index]);

            int initial = nums[index];
            int prev = initial;
            while(++index < nums.length && prev + 1 == nums[index]) {
                prev = nums[index];
            }
            if(prev != initial) {
                sb.append("->");
                sb.append(prev);
            }
            res.add(sb.toString());
        }

        return res;
    }
}

package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + 1 != nums[i]) {
                for(int j = nums[i - 1] + 1; j < nums[i]; j++) {
                    res.add(j);
                }
            }
        }
        return res;
    }
}

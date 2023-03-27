package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return new ArrayList(res);
    }

    private void backtrack(int[] nums, int index, List<Integer> tmp, Set<List<Integer>> res) {
        if(index == nums.length) {
            if(tmp.size() >= 2) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        if(tmp.isEmpty() || tmp.get(tmp.size() - 1) <= nums[index]) {
            tmp.add(nums[index]);
            backtrack(nums, index + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
        backtrack(nums, index + 1, tmp, res);
    }
}

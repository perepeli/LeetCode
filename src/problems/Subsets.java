package problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() > nums.length) {
            return;
        } else {
            res.add(new ArrayList<>(temp));

            for(int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

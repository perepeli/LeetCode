package problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> res) {
        if(target <= 0) {
            if(target == 0) res.add(new ArrayList<Integer>(temp));
        } else {
            for(int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

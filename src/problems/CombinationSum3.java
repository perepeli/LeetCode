package problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int sum, int k, List<Integer> temp, List<List<Integer>> res) {
        if(sum < 0) return;
        if(k == 0) {
            if(sum == 0) {
                res.add(new ArrayList<>(temp));
            }
        } else {
            for(int i = index; i <= 9; i++) {
                temp.add(i);
                backtrack(i + 1, sum - i, k - 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

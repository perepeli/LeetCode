package problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int s, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for(int i = s; i <= n - k + 1; i++) {
                temp.add(i);
                backtrack(++s, n, k-1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

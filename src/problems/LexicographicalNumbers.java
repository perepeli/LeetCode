package problems;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++) dfs(n, i, res);
        return res;
    }

    private void dfs(int max, int num, List<Integer> res) {
        if(num > max) return;

        res.add(num);
        int nextNum = num * 10;

        for(int i = 0; i < 10; i++) {
            dfs(max, nextNum + i, res);
        }
    }
}

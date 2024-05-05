package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int n, int leftCount, int rightCount, StringBuilder temp, List<String> res) {
        if(temp.length() == n * 2) {
            res.add(temp.toString());
        } else {
            if(leftCount < n) {
                temp.append('(');
                backtrack(n, leftCount + 1, rightCount, temp, res);
                temp.deleteCharAt(temp.length() - 1);
            }

            if(rightCount < leftCount) {
                temp.append(')');
                backtrack(n, leftCount, rightCount + 1, temp, res);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}

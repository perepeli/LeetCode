package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int maxPairs, int left, int right, StringBuilder sb, List<String> result) {
        if(left == maxPairs && right == maxPairs) {
            result.add(sb.toString());
        } else {
            if(left == maxPairs) { // left full, only right
                sb.append(')');
                backtrack(maxPairs, left, right + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            } else {

                if(left > right) { // can add right, there's a matching left
                    sb.append(')');
                    backtrack(maxPairs, left, right + 1, sb, result);
                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append('('); // left
                backtrack(maxPairs, left + 1, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

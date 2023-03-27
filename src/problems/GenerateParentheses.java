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
        if(left == maxPairs && right == maxPairs) { // we're done
            result.add(sb.toString());
            return;
        }

        if(left == maxPairs) { // left is full, can add only right
            sb.append(')');
            backtrack(maxPairs, left, right + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        } else { // left is not full, have place for both
            if(left > right) { // both
                sb.append('(');
                backtrack(maxPairs, left + 1, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(')');
                backtrack(maxPairs, left, right + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            } else { // only left
                sb.append('(');
                backtrack(maxPairs, left + 1, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

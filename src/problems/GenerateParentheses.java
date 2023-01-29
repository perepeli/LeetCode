package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void recursive(StringBuilder sb, int left, int right, int maxPairs, List<String> res) {
        if(left == maxPairs && right == maxPairs) { // base case : we're done
            res.add(sb.toString());
            return;
        }
        if(left == maxPairs) { // left is full, right is not
            StringBuilder newSb = new StringBuilder();
            newSb.append(sb);
            newSb.append(')');
            recursive(newSb, left, right + 1, maxPairs, res);

        } else { // have place for both
            if(left > right) { // right has matching left
                StringBuilder newLeftSb = new StringBuilder();
                StringBuilder newRightSb = new StringBuilder();

                newLeftSb.append(sb);
                newRightSb.append(sb);

                newLeftSb.append('(');
                newRightSb.append(')');

                recursive(newLeftSb, left + 1, right, maxPairs, res);
                recursive(newRightSb, left, right + 1, maxPairs, res);

            } else { // no matching left
                StringBuilder newSb = new StringBuilder();
                newSb.append(sb);
                newSb.append('(');
                recursive(newSb, left + 1, right, maxPairs, res);
            }
        }
    }
}

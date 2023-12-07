package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String s : nums) set.add(s);
        List<String> res = new ArrayList<>();
        backtrack(nums.length, set, new StringBuilder(), res);
        return res.size() > 0 ? res.get(0) : null;

    }

    private void backtrack(int n, Set<String> set, StringBuilder sb, List<String> res) {
        if(n == 0) {
            if(!set.contains(sb.toString())) {
                res.add(sb.toString());
            }
        } else {
            sb.append('0');
            backtrack(n - 1, set, sb, res);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('1');
            backtrack(n - 1, set, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

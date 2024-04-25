package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IteratorForCombination {
    private List<String> generated;
    private int index;

    public IteratorForCombination(String characters, int combinationLength) {
        generated = new ArrayList<>();
        char[] chars = characters.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, combinationLength, 0, new StringBuilder(), generated);
        index = 0;
    }

    public String next() {
        return generated.get(index++);
    }

    public boolean hasNext() {
        return index < generated.size();
    }

    private void backtrack(char[] chars, int length, int index, StringBuilder sb, List<String> res) {
        if(sb.length() == length) {
            res.add(sb.toString());
            return;
        }
        for(int i = index; i < chars.length; i++) {
            sb.append(chars[i]);
            backtrack(chars, length, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

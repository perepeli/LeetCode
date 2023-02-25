package problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, new StringBuilder(), 0, result);
        return result;
    }

    private void backtrack(String s, StringBuilder sb, int index, List<String> result) {
        if(sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }

        Character current = s.charAt(index);

        if(Character.isAlphabetic(current)) {
            sb.append(Character.toUpperCase(current));
            backtrack(s, sb, index + 1, result);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toLowerCase(current));
            backtrack(s, sb, index + 1, result);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(current);
            backtrack(s, sb, index + 1, result);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}

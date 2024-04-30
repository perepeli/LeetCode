package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        List<String> result = new ArrayList<>();
        backtrack(pattern, -1, new StringBuilder(), new boolean[10], result);
        Collections.sort(result);

        return result.size() > 0 ? result.get(0) : "";
    }

    private void backtrack(String pattern, int index, StringBuilder sb, boolean[] used, List<String> result) {
        if(index == pattern.length()) {
            result.add(sb.toString());
        } else {
            if(index == -1) {
                for(int i = 1; i < 10; i++) {
                    sb.append(i);
                    used[i - 1] = true;
                    backtrack(pattern, index + 1, sb, used, result);
                    used[i - 1] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                for(int i = 1; i < 10; i++) {
                    if(used[i - 1] == true) continue;

                    char currentPattern = pattern.charAt(index);

                    if(currentPattern == 'I' && i > (sb.charAt(sb.length() - 1) - '0')) {
                        sb.append(i);
                        used[i - 1] = true;
                        backtrack(pattern, index + 1, sb, used, result);
                        used[i - 1] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }

                    if(currentPattern == 'D' && i < (sb.charAt(sb.length() - 1) - '0')) {
                        sb.append(i);
                        used[i - 1] = true;
                        backtrack(pattern, index + 1, sb, used, result);
                        used[i - 1] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }
}

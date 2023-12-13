package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BraceExpansion {

    public String[] expand(String s) {
        int len = s.replaceAll("\\{.*?\\}", "*").length();
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), len, 0, new StringBuilder(), res);
        return res.stream().sorted().toArray(String[]::new);
    }

    private void backtrack(char[] s, int len, int index, StringBuilder sb, List<String> res) {
        if(sb.length() == len) {
            res.add(sb.toString());
        } else {
            if(s[index] == '{') {
                int endIndex = index + 1;
                while(s[endIndex] != '}') {
                    endIndex++;
                }
                for(int i = index + 1; i < endIndex; i++) {
                    if(s[i] == ',') continue;
                    sb.append(s[i]);
                    backtrack(s, len, endIndex + 1, sb, res);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s[index]);
                backtrack(s, len, index + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

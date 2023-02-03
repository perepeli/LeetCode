package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        Map<Character, String> map = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );

        backTrackPrint(map, digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backTrackPrint(Map<Character, String> map, String digits, int index, StringBuilder sb, List<String> res) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
        } else {
            for(int i = 0; i < map.get(digits.charAt(index)).length(); i++) {
                char ch = map.get(digits.charAt(index)).charAt(i);
                sb.append(ch);
                backTrackPrint(map, digits, index + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);

            }
        }
    }
}

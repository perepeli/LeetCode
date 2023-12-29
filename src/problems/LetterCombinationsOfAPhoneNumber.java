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

        backtrack(digits.toCharArray(), 0, map, new StringBuilder(), res);

        return res;
    }

    private void backtrack(char[] arr, int index, Map<Character, String> map, StringBuilder sb, List<String> res) {
        if(index == arr.length) {
            res.add(sb.toString());
        } else {
            for(char c : map.get(arr[index]).toCharArray()) {
                sb.append(c);
                backtrack(arr, index + 1, map, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

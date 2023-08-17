package problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> temp, List<List<String>> res) {
        if(start >= s.length()) res.add(new ArrayList<>(temp));

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                temp.add(s.substring(start, end + 1));
                backtrack(s, end + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

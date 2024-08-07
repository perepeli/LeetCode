package problems;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return recursive(s, 0, s.length() - 1, 1);
    }

    private boolean recursive(String s, int left, int right, int maxAllowed) {
        if(right <= left) return true;

        if(s.charAt(left) == s.charAt(right)) {
            return recursive(s, left + 1, right - 1, maxAllowed);
        } else {
            maxAllowed--;
            if (maxAllowed < 0) return false;
            return recursive(s, left + 1, right, maxAllowed) || recursive(s, left, right - 1, maxAllowed);
        }
    }
}

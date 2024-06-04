package problems;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        boolean hasOdd = false;
        for (int v: count) {
            ans += v % 2 == 0 ? v : v - 1;
            if(!hasOdd && v % 2 == 1) hasOdd = true;
        }

        return ans + (hasOdd ? 1 : 0);
    }
}

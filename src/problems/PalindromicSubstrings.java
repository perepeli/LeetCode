package problems;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int substrings = 0;

        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while((left >= 0) && (right <= (s.length()-1)) && (s.charAt(left) == s.charAt(right))) { // even case
                left--;
                right++;
                substrings++;;
            }

            left = i;
            right = i+1;

            while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) { // odd case
                left--;
                right++;
                substrings++;
            }
        }

        return substrings;

    }
}

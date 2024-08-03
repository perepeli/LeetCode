package problems;

public class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        int[] indexes = new int[26];
        for(int i = 0; i < s.length(); i++) {
            indexes[s.charAt(i) - 'a'] = i;
        }

        int res = 0;

        for(int i = 0; i < t.length(); i++) {
            res += Math.abs(i - indexes[t.charAt(i) - 'a']);
        }

        return res;
    }
}

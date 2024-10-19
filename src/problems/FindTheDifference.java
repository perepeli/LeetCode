package problems;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] frequency = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency[c - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(--frequency[c - 'a'] == -1) return c;
        }

        throw new RuntimeException("invalid input");
    }
}

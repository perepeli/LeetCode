package problems;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        boolean duplicate = false;

        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if(freq[s.charAt(i) - 'a'] > 1) duplicate = true;
        }
        for(int i = 0; i < goal.length(); i++) {
            freq[goal.charAt(i) - 'a']--;
        }
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) return false;
        }

        int misplaced = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) misplaced++;
        }

        if(misplaced == 2 || (misplaced == 0 && duplicate)) return true;
        return false;
    }
}

package problems;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int index = 0;

        for(int i = 0; i < t.length() && index < s.length(); i++) {
            if(t.charAt(i) == s.charAt(index)) index++;
        }

        return index == s.length();
    }
}

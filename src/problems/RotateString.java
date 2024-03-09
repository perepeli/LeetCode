package problems;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < goal.length(); j++) {
                char charJ = goal.charAt(j);
                char charI = s.charAt((i + j) % s.length());
                if(charJ != charI) break;

                if(j == goal.length() - 1) return true;
            }
        }

        return false;
    }
}

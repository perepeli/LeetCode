package problems;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int index = 0; //0
        int length = s.length() -1; //2

        for(int i = 0; i < t.length(); i++) {
            if(index == length+1) return true; //==3?

            char cs = s.charAt(index);
            char ct = t.charAt(i);
            boolean b = cs == ct;
            if(t.charAt(i) == s.charAt(index)) {
                index++;
            }
        }
        if(index == length+1) return true;

        return false;
    }
}

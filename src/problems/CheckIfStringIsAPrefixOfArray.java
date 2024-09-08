package problems;

public class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        int sIndex = 0;

        for(String str : words) {
            if(sIndex == s.length()) break;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != s.charAt(sIndex++)) return false;
                if(sIndex == s.length()) {
                    if(i == str.length() - 1) break;
                    return false;
                }
            }
        }

        return sIndex == s.length();
    }
}

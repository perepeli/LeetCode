package problems;

public class AppendCharactersToStringToMakeSubsequence {
    public int appendCharacters(String s, String t) {
        int index = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(index)) {
                index++;
                if(index == t.length()) return 0;
            }
        }

        return t.length() - index;
    }
}

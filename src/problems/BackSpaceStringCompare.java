package problems;

import java.util.ArrayList;
import java.util.List;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        List<Character> stackS = new ArrayList<>();
        List<Character> stackT = new ArrayList<>();

        for(char e: sArr) {
            if(e == '#') {
                if(!stackS.isEmpty()) {
                    stackS.remove(stackS.size()-1);
                }
            } else {
                stackS.add(e);
            }
        }

        for(char e: tArr) {
            if(e == '#') {
                if(!stackT.isEmpty()) {
                    stackT.remove(stackT.size()-1);
                }
            } else {
                stackT.add(e);
            }
        }

        if(stackS.size() != stackT.size()) return false;

        for(int i = 0; i < stackS.size(); i++) {
            if(stackS.get(i) != stackT.get(i)) return false;
        }
        return true;
    }
}

package problems;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();

        //left push
        //right pop

        boolean isValid = true;

        for(char c: s.toCharArray()) {
            if(c == '}' || c == ']' || c == ')') { // encountered right
                char right = c;
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                } else {
                    char left = stack.get(stack.size() - 1);
                    if((left == '{' && right == '}') || (left == '[' && right == ']') || (left == '(' && right == ')')) {
                        stack.remove(stack.size() - 1);
                        continue;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if(c == '{' || c == '[' || c == '(') { // encountered left
                stack.add(c);
            }
        }

        if(stack.size() > 0) return false;
        return isValid;
    }
}

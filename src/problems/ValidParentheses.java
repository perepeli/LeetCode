package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            if(ch == ')' || ch == ']' || ch == '}') {
                if(stack.isEmpty()) return false;
                char potentialLeft = stack.pop();

                if(potentialLeft == '(' && ch == ')') continue;
                if(potentialLeft == '[' && ch == ']') continue;
                if(potentialLeft == '{' && ch == '}') continue;
                return false;
            }
        }

        if(stack.size() != 0) return false;
        return true;
    }
}

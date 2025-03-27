package problems;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ')') {
                if(deque.isEmpty() || deque.removeLast() != '(') return false;
            } else if(c == '}') {
                if(deque.isEmpty() || deque.removeLast() != '{') return false;
            } else if(c == ']') {
                if(deque.isEmpty() || deque.removeLast() != '[') return false;
            } else {
                deque.addLast(c);
            }
        }

        return deque.isEmpty();
    }
}

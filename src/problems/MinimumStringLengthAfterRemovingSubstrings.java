package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(stack.isEmpty()) stack.push(c);
            else if(c == 'B' && stack.peek() == 'A') stack.pop();
            else if(c == 'D' && stack.peek() == 'C') stack.pop();
            else stack.push(c);
        }

        return stack.size();
    }
}

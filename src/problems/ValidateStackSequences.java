package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int toPopIndex = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < pushed.length; i++) {
            stack.addLast(pushed[i]);

            while(!stack.isEmpty() && toPopIndex < popped.length && stack.peekLast() == popped[toPopIndex]) {
                stack.removeLast();
                toPopIndex++;
            }
        }

        return stack.size() == 0;
    }
}

package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.addLast(new int[]{val, stack.isEmpty() ? val : Math.min(stack.peekLast()[1], val)});
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.peekLast()[0];
    }

    public int getMin() {
        return stack.peekLast()[1];
    }
}

package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<int[]> stack = new ArrayDeque<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {}

    public void push(int val) {
        stack.push(new int[]{val, Math.min(min, val)});
        min = stack.peek()[1];
    }

    public void pop() {
        stack.pop();
        if(stack.isEmpty()) min = Integer.MAX_VALUE;
        else min = stack.peek()[1];
    }

    public int top() {
        if(stack.isEmpty()) return Integer.MAX_VALUE;
        else return stack.peek()[0];
    }

    public int getMin() {
        return min;
    }
}

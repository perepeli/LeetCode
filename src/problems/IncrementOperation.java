package problems;

public class IncrementOperation {
    public static class CustomStack {
        int[] stack;
        int top;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            top = -1;
        }

        public void push(int x) {
            if(top + 1 < stack.length) stack[++top] = x;
        }

        public int pop() {
            return (top > -1) ? stack[top--] : -1;
        }

        public void increment(int k, int val) {
            if(top > -1) {
                for(int i = 0; i < Math.min(top + 1, k); i++) {
                    stack[i] += val;
                }
            }
        }
    }
}

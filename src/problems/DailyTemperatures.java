package problems;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            int curr = temperatures[i];

            while(!stack.isEmpty() && stack.peekLast()[0] <= curr) {
                stack.removeLast();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peekLast()[1] - i;
            stack.addLast(new int[]{curr, i});
        }

        return res;
    }
}

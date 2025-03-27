package problems;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
            int curr = temperatures[i];
            while(!stack.isEmpty() && stack.peekLast()[0] <= curr) stack.removeLast();
            if(!stack.isEmpty()) res[i] = stack.peekLast()[1] - i;
            stack.offer(new int[]{curr, i});
        }

        return res;
    }
}

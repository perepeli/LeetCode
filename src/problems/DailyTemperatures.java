package problems;

import java.util.AbstractMap;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<AbstractMap.SimpleEntry<Integer, Integer>> stack = new Stack<>(); //monotonic increasing stack

        for(int i = temperatures.length-1; i >= 0; i--) {
            int current = temperatures[i];
            while(!stack.isEmpty() && stack.peek().getKey() <= current) {
                stack.pop();
            }

            if(!stack.isEmpty()) result[i] = stack.peek().getValue() - i;

            stack.push(new AbstractMap.SimpleEntry<Integer, Integer>(temperatures[i], i));
        }

        return result;

    }

}

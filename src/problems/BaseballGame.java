package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Deque<String> stack = new ArrayDeque<>();

        for(int i = 0; i < operations.length; i++) {
            if("+".equals(operations[i])) {
                String temp = stack.pop();
                String temp2 = String.valueOf(Integer.parseInt(stack.peek()) + Integer.parseInt(temp));
                stack.push(temp);
                stack.push(temp2);
            } else if("D".equals(operations[i])) {
                stack.push(String.valueOf(Integer.parseInt(stack.peek()) * 2));
            } else if("C".equals(operations[i])) {
                stack.pop();
            } else {
                stack.push(operations[i]);
            }
        }

        int sum = 0;

        while(!stack.isEmpty()) sum += Integer.parseInt(stack.pop());

        return sum;
    }
}

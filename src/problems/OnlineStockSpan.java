package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    Deque<int[]> stack = new ArrayDeque<>();

    public int next(int price) {
        int days = 1;
        while(!stack.isEmpty() && stack.peekLast()[0] <= price) {
            days += stack.removeLast()[1];
        }
        stack.addLast(new int[]{price, days});
        return days;
    }
}

package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[prices.length];

        for(int i = prices.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peekLast() > prices[i]) stack.removeLast();

            if(stack.isEmpty()) res[i] = prices[i];
            else res[i] = prices[i] - stack.peekLast();

            stack.addLast(prices[i]);
        }

        return res;
    }
}

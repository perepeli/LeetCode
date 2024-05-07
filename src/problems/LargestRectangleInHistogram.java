package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] heightsLeft = new int[heights.length];
        int[] heightsRight = new int[heights.length];

        Arrays.fill(heightsLeft, -1);
        Arrays.fill(heightsRight, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) stack.removeLast();
            if (!stack.isEmpty()) heightsLeft[i] = stack.peekLast();
            stack.addLast(i);
        }

        stack = new ArrayDeque<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) stack.removeLast();
            if (!stack.isEmpty()) heightsRight[i] = stack.peekLast();
            stack.addLast(i);
        }

        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int from = heightsLeft[i] + 1;
            int to = heightsRight[i] - 1;
            int minHeight = Math.min(heights[i], Math.min(heights[from], heights[to]));
            int width = to - from + 1;
            max = Math.max(max, minHeight * width);
        }

        return max;
    }
}

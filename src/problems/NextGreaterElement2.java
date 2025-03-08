package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                stack.removeLast();
            }
            stack.addLast(nums[i]);
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                stack.removeLast();
            }

            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peekLast();

            stack.addLast(nums[i]);
        }

        return res;
    }
}

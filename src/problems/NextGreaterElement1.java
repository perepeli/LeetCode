package problems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peekLast() < nums2[i]) stack.removeLast();

            if(stack.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peekLast());

            stack.addLast(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

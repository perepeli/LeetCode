package problems;

import problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        Deque<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.offer(root);
                root = root.left;
            }

            root = stack.removeLast();

            if(prev <= target && target < root.val) {
                return Math.abs(prev - target) <= Math.abs(root.val - target) ? (int) prev : root.val;
            }

            prev = root.val;
            root = root.right;
        }

        return (int) prev;
    }
}

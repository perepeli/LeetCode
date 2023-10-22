package problems;

import problems.util.TreeNode;
import problems.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        //return maxDepthRecursive(root);
        return maxDepthIterative(root);
    }

    private int maxDepthRecursive(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = 1 + maxDepthRecursive(root.left);
        int rightDepth = 1 + maxDepthRecursive(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    private int maxDepthIterative(TreeNode root) {
        if(root == null) return 0;

        int maxDepth = 0;

        Deque<problems.util.Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 1));

        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();

            maxDepth = Math.max(maxDepth, depth);
            if(node.left != null) stack.push(new Pair<>(node.left, depth + 1));
            if(node.right != null) stack.push(new Pair<>(node.right, depth + 1));
        }

        return maxDepth;
    }
}

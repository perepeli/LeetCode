package problems;

import problems.listnode.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepthRecursive(root, 0);
    }

    private int maxDepthRecursive(TreeNode current, int currentDepth) {
        if(current == null) return 0;
        currentDepth++;
        if(current.left == null && current.right == null) return currentDepth;
        if(current.left != null && current.right == null) return maxDepthRecursive(current.left, currentDepth);
        if(current.right != null && current.left == null) return maxDepthRecursive(current.right, currentDepth);

        return Math.max(maxDepthRecursive(current.left, currentDepth), maxDepthRecursive(current.right, currentDepth));
    }
}

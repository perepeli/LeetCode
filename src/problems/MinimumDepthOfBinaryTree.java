package problems;

import problems.util.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return recursive(root, 0);
    }

    private int recursive(TreeNode node, int depth) {
        depth++;
        if (node.left == null && node.right == null) return depth;
        else if (node.left != null && node.right == null) return recursive(node.left, depth);
        else if (node.right != null && node.left == null) return recursive(node.right, depth);
        else return Math.min(recursive(node.left, depth), recursive(node.right, depth));
    }
}

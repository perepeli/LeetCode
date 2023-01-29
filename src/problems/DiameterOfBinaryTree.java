package problems;

import problems.listnode.TreeNode;

public class DiameterOfBinaryTree {
    public static int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        recursive(root, 0);
        return max;
    }

    private int recursive(TreeNode node, int height) {
        if(node == null) return 0;

        int left = recursive(node.left, height);
        int right = recursive(node.right, height);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}

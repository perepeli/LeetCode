package problems;

import problems.listnode.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] out = {0};
        recursive(root, 0, out);
        return out[0];
    }

    private int recursive(TreeNode node, int height, int[] max) {
        if(node == null) return 0;

        int left = recursive(node.left, height, max);
        int right = recursive(node.right, height, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }
}

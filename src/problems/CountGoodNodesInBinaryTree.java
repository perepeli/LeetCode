package problems;

import problems.util.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        recursive(root, root.val, res);
        return res[0];

    }

    private void recursive(TreeNode node, int max, int[] res) {
        if(node == null) return;

        if(node.val >= max) res[0]++;

        recursive(node.left, Math.max(max, node.val), res);
        recursive(node.right, Math.max(max, node.val), res);
    }
}

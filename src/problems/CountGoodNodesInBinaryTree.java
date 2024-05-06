package problems;

import problems.util.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        dfs(root, root.val, res);
        return res[0];
    }

    private void dfs(TreeNode node, int max, int[] res) {
        if(node == null) return;

        if(node.val >= max) res[0]++;

        max = Math.max(max, node.val);

        dfs(node.left, max, res);
        dfs(node.right, max, res);
    }
}

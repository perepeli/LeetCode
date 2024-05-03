package problems;

import problems.util.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] res = new int[]{0};
        dfs(root, false, res);
        return res[0];
    }

    private void dfs(TreeNode node, boolean isLeft, int[] res) {
        if(node == null) return;

        if(node.left == null && node.right == null) {
            if(isLeft) res[0] += node.val;
            return;
        }

        dfs(node.left, true, res);
        dfs(node.right, false, res);
    }
}

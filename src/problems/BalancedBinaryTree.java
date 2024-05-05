package problems;

import problems.util.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[1] == 1;
    }

    private int[] dfs(TreeNode node) {
        if(node == null) return new int[]{0, 1};
        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);

        if(leftRes[1] == 0 || rightRes[1] == 0) return new int[]{-1, 0};
        if(Math.abs(leftRes[0] - rightRes[0]) > 1) return new int[]{-1, 0};

        return new int[]{1 + Math.max(leftRes[0], rightRes[0]), 1};

    }
}

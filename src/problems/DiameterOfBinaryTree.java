package problems;

import problems.util.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode node) {
        if(node == null) return new int[]{0, 0};
        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);

        int leftDepth = leftRes[0];
        int rightDepth = rightRes[0];
        int currentMaxDiameter = leftDepth + rightDepth;

        return new int[]{1 + Math.max(leftDepth, rightDepth), Math.max(currentMaxDiameter, Math.max(leftRes[1], rightRes[1]))};
    }
}

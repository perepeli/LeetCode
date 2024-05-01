package problems;

import problems.util.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;

        if(min != null && node.val <= min) return false;
        if(max != null && node.val >= max) return false;

        boolean leftResult = dfs(node.left, min, node.val);
        boolean rightResult = dfs(node.right, node.val, max);

        return leftResult && rightResult;
    }
}

package problems;

import problems.util.TreeNode;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if(node == null) return false;
        if(node.left == null && node.right == null) {
            return node.val == 0 ? false : true;
        } else {
            boolean left = dfs(node.left);
            boolean right = dfs(node.right);

            if(node.val == 2) {
                return left || right;
            }

            if(node.val == 3) {
                return left && right;
            }

            return false;
        }
    }
}

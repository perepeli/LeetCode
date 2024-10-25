package problems;

import problems.util.TreeNode;

public class BinaryTreeTilt {
    int res;
    public int findTilt(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res += Math.abs(left - right);
        return node.val + left + right;
    }
}

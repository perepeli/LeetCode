package problems;

import problems.util.TreeNode;

public class LowestCommonAncestorOfABinaryTree2 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        dfs(root, p.val, q.val);
        return res;
    }

    private int dfs(TreeNode node, int p, int q) {
        if(node == null) return 0;

        if(res != null) return 0;

        int left = dfs(node.left, p, q);
        int right = dfs(node.right, p, q);

        int result = left + right;
        if(node.val == p || node.val == q) result++;

        if(result == 2 && res == null) res = node;

        return result;
    }
}

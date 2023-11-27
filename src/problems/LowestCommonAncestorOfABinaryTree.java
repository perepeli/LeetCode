package problems;

import problems.util.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        recursive(root, p, q);
        return res;
    }

    private boolean recursive(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;

        int left = recursive(node.left, p, q) ? 1 : 0;
        int right = recursive(node.right, p, q) ? 1 : 0;
        int curr = node.val == p.val || node.val == q.val ? 1 : 0;

        if(left + right + curr >= 2) res = node;

        return left + right + curr > 0;
    }
}

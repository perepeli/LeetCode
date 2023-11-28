package problems;

import problems.util.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        TreeNode min = p.val < q.val ? p : q;
        TreeNode max = p.val > q.val ? p : q;
        recursive(root, min, max);
        return res;
    }

    private boolean recursive(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;

        if(p.val < node.val && q.val < node.val) {
            return recursive(node.left, p, q);
        } else if(p.val > node.val && q.val > node.val) {
            return recursive(node.right, p, q);
        } else {
            int curr = (node.val == p.val || node.val == q.val) ? 1 : 0;
            int left = recursive(node.left, p, q) ? 1 : 0;
            int right = recursive(node.right, p, q) ? 1 : 0;

            if(curr + left + right == 2) {
                res = node;
                return true;
            } else if (curr + left + right == 1){
                return true;
            } else {
                return false;
            }
        }
    }
}

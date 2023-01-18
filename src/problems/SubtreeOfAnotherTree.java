package problems;

import problems.listnode.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean[] out = new boolean[1];
        recursive(root, subRoot, out);
        return out[0];
    }

    private void recursive(TreeNode node, TreeNode subRoot, boolean[] out) {
        if(node == null || out[0]) return;

        recursive(node.left, subRoot, out);
        if(isSimilar(node, subRoot)) out[0] = true;
        recursive(node.right, subRoot, out);
    }

    private boolean isSimilar(TreeNode first, TreeNode second) {
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;
        if(first.val != second.val) return false;

        return isSimilar(first.left, second.left) && isSimilar(first.right, second.right);
    }
}

package problems;

import problems.util.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        boolean hasOne = prune(root);
        if(!hasOne) return null;
        return root;
    }

    private boolean prune(TreeNode node) {
        if(node == null) return false;

        boolean leftHasOne = prune(node.left);
        boolean rightHasOne = prune(node.right);

        if(!leftHasOne) node.left = null;
        if(!rightHasOne) node.right = null;

        if(leftHasOne || rightHasOne || node.val == 1) return true;
        return false;
    }
}

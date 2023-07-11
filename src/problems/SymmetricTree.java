package problems;

import problems.util.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return recursive(root.left, root.right);
    }

    private boolean recursive(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left != null && right == null) return false;
        if(right != null && left == null) return false;

        if(left.val != right.val) return false;

        return recursive(left.left, right.right) && recursive(left.right, right.left);

    }
}

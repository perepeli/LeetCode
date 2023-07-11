package problems;

import problems.util.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    private void recursive(TreeNode node) {
        if(node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        recursive(node.left);
        recursive(node.right);
    }
}

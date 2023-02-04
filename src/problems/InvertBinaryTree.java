package problems;

import problems.listnode.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        recursive(root);
        return root;
    }

    private void recursive(TreeNode node) {
        if(node.left == null && node.right == null) { // both null
            return;
        } else if(node.left != null && node.right == null) { // left not right yes
            node.right = node.left;
            node.left = null;
            recursive(node.right);
        } else if(node.left == null && node.right != null) { // left yes right not
            node.left = node.right;
            node.right = null;
            recursive(node.left);
        } else { // both present
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            recursive(node.left);
            recursive(node.right);
        }

    }
}

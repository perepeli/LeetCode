package problems;

import problems.util.TreeNode;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
                return root;
            }
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }



    private TreeNode successor(TreeNode node) {
        node = node.right;
        while(node.left != null) node = node.left;
        return node;
    }
}

package problems;

import problems.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode prev = new TreeNode();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);;
            prev.left = null;
            prev.right = node;
            prev = node;
        }
    }
}

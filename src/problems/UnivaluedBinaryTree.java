package problems;

import problems.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        int num = root.val;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.val != num) return false;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        return true;
    }
}

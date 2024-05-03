package problems;

import problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int res = 0;

        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            if(node.left != null) {
                if(node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                } else {
                    queue.addLast(node.left);
                }
            }

            if(node.right != null) queue.addLast(node.right);
        }

        return res;
    }
}

package problems;

import problems.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        Integer secondMin = null;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) continue;

            if(node.left != null) {
                if(node.left.val != node.right.val) {
                    if(secondMin == null) {
                        secondMin = Math.max(node.left.val, node.right.val);
                    } else {
                        secondMin = Math.min(secondMin, Math.max(node.left.val, node.right.val));
                    }
                }

                if(node.left.val == node.right.val) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else if(node.left.val < node.right.val) {
                    queue.offer(node.left);
                } else if(node.left.val > node.right.val) {
                    queue.offer(node.right);
                }
            }
        }

        if(secondMin == null) return -1;
        return secondMin;
    }
}

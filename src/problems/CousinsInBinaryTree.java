package problems;

import problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.val == x || root.val == y)) return false;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            boolean foundX = false;
            boolean foundY = false;

            int currentLevelSize = queue.size();

            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if(node.val == x) foundX = true;
                if(node.val == y) foundY = true;

                if(node.left != null && node.right != null) {
                    if((node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y)) return false;
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            if(foundX && foundY) return true;
            if(foundX || foundY) return false;
        }

        return false;
    }
}

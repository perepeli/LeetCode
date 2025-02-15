package problems;

import problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean encounteredNull = false;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) {
                encounteredNull = true;
            } else {
                if(encounteredNull) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}

package problems;

import problems.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int levelNodes = queue.size();
            TreeNode prev = null;

            while(levelNodes-- > 0) {
                TreeNode curr = queue.poll();
                if(level % 2 == 0 && curr.val % 2 == 0) return false;
                if(level % 2 != 0 && curr.val % 2 != 0) return false;
                if(prev != null) {
                    if(level % 2 == 0) {
                        if(prev.val >= curr.val) return false;
                    } else {
                        if(prev.val <= curr.val) return false;
                    }
                }
                prev = curr;
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            level++;
        }

        return true;
    }
}

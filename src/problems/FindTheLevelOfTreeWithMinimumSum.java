package problems;

import problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FindTheLevelOfTreeWithMinimumSum {
    public int minimumLevel(TreeNode root) {
        long minSum = Long.MAX_VALUE;
        int minLevel = -1;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 1;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            if(minLevel == -1 || levelSum < minSum) {
                minLevel = currentLevel;
                minSum = levelSum;
            }

            currentLevel++;
        }

        return minLevel;
    }
}

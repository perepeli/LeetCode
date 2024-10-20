package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            List<TreeNode> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(currentLevel % 2 == 1) level.add(node);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            if(currentLevel % 2 == 1) {
                for(int i = 0; i < level.size() / 2; i++) {
                    int temp = level.get(i).val;
                    level.get(i).val = level.get(level.size() - 1 - i).val;
                    level.get(level.size() - 1 - i).val = temp;
                }
            }

            currentLevel++;
        }

        return root;
    }
}

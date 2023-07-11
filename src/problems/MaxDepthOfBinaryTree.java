package problems;


import problems.util.TreeNode;

import java.util.AbstractMap;
import java.util.Stack;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) { // iterative dfs
        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        int max = 0;

        stack.add(new AbstractMap.SimpleEntry<>(root, 1));

        while(!stack.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> pair = stack.pop();

            if(pair.getKey() != null) {
                max = Math.max(max, pair.getValue());

                stack.add(new AbstractMap.SimpleEntry<>(pair.getKey().right, pair.getValue() + 1));
                stack.add(new AbstractMap.SimpleEntry<>(pair.getKey().left, pair.getValue() + 1));
            }
        }

        return max;
    }

    private int recursive(TreeNode node) { // might cause stackoverflow with large input trees
        if(node == null) return 0;
        return 1 + Math.max(recursive(node.left), recursive(node.right));
    }
}

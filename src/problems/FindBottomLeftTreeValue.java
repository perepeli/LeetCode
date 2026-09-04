package problems;

import problems.util.TreeNode;

public class FindBottomLeftTreeValue {
    private int maxDepth = -1;
    private int maxDepthLeftValue = -1;
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        maxDepthLeftValue = -1;
        dfs(root, 0);
        return maxDepthLeftValue;
    }

    private void dfs(TreeNode node, int depth) {
        if(node == null) return;
        if(depth > maxDepth) {
            maxDepth = depth;
            maxDepthLeftValue = node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}

package problems;

import problems.listnode.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return recursive(root, targetSum);
    }

    private boolean recursive(TreeNode node, int pathSum) {
        pathSum -= node.val;
        if(node.left == null && node.right == null) return (pathSum == 0);
        else if(node.left != null && node.right == null) return recursive(node.left, pathSum);
        else if(node.right != null && node.left == null) return recursive(node.right, pathSum);
        else return recursive(node.left, pathSum) || recursive(node.right, pathSum);
    }
}

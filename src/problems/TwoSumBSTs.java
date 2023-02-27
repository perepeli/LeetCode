package problems;

import problems.listnode.TreeNode;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        return dfs(root1, root2, target);
    }

    private boolean dfs(TreeNode node, TreeNode root2, int target) {
        if(node == null) return false;
        if(searchBST(root2, target - node.val)) return true;
        return dfs(node.left, root2, target) || dfs(node.right, root2, target);
    }

    private boolean searchBST(TreeNode node, int target) {
        if(node == null) return false;
        if(node.val == target) return true;
        if(target > node.val) {
            return searchBST(node.right, target);
        } else {
            return searchBST(node.left, target);
        }
    }
}

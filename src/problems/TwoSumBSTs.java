package problems;

import problems.util.TreeNode;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        return dfs(root1, root2, target);
    }

    private boolean dfs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null) return false;
        if(searchBST(root2, target - root1.val)) return true;
        return dfs(root1.left, root2, target) || dfs(root1.right, root2, target);
    }

    private boolean searchBST(TreeNode root2, int target) {
        if(root2 == null) return false;
        if(root2.val == target) return true;
        if(root2.val > target) {
            return searchBST(root2.left, target);
        } else {
            return searchBST(root2.right, target);
        }

    }
}

package problems;

import problems.util.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[]{0};
        dfs(null, root, 0, res);
        return res[0];
    }

    private void dfs(TreeNode prev, TreeNode curr, int streak, int[] res) {
        if(curr == null) return;
        if(prev != null && prev.val + 1 == curr.val) {
            streak += 1;
        } else {
            streak = 1;
        }
        res[0] = Math.max(res[0], streak);
        dfs(curr, curr.left, streak, res);
        dfs(curr, curr.right, streak, res);
    }
}

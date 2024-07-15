package problems;

import problems.util.TreeNode;

public class CountNodesEqualToAverageOfSubtree {
    private int res;

    public int averageOfSubtree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        int[] ret = new int[]{0, 0};
        if(node == null) return ret;

        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);

        ret[0] += leftRes[0];
        ret[0] += rightRes[0];

        ret[1] += leftRes[1];
        ret[1] += rightRes[1];

        ret[0] += node.val;
        ret[1]++;

        if(ret[1] != 0) {
            if(ret[0] / ret[1] == node.val) res++;
        }

        return ret;
    }
}

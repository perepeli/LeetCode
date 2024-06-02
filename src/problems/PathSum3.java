package problems;

import problems.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> prefixPathSum = new HashMap<>();
        prefixPathSum.put(0L, 1L);

        int[] res = new int[]{0};
        dfs(root, prefixPathSum, 0L, targetSum, res);
        return res[0];
    }

    private void dfs(TreeNode node, Map<Long, Long> prefixPathSum, long prefixSum, int targetSum, int[] res) {
        if(node == null) return;
        prefixSum += node.val;

        Long toFind = 0L + prefixSum - targetSum;
        if(prefixPathSum.containsKey(toFind)) res[0] += prefixPathSum.get(toFind);

        prefixPathSum.put(prefixSum, prefixPathSum.getOrDefault(prefixSum, 0L) + 1);
        dfs(node.left, prefixPathSum, prefixSum, targetSum, res);
        dfs(node.right, prefixPathSum, prefixSum, targetSum, res);
        prefixPathSum.put(prefixSum, prefixPathSum.get(prefixSum) - 1);
        if(prefixPathSum.get(prefixSum) == 0) prefixPathSum.remove(prefixSum);
    }
}

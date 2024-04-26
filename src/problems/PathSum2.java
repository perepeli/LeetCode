package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), 0, res);
        return res;
    }

    private boolean dfs(TreeNode root, int targetSum, List<Integer> temp, int sum, List<List<Integer>> res) {
        if(root == null) return false;

        sum += root.val;
        temp.add(root.val);

        boolean hasLeft = dfs(root.left, targetSum, temp, sum, res);
        boolean hasRight = dfs(root.right, targetSum, temp, sum, res);

        if(!hasLeft && !hasRight) {
            if(sum == targetSum) res.add(new ArrayList<>(temp));
        }

        temp.remove(temp.size() - 1);
        return true;
    }
}

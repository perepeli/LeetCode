package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode node, List<List<Integer>> res) {
        if(node == null) return -1;

        int left = dfs(node.left, res);
        int right = dfs(node.right, res);

        int curr = Math.max(left, right) + 1;

        if(res.size() <= curr) res.add(new ArrayList<>());

        res.get(curr).add(node.val);

        return curr;
    }
}

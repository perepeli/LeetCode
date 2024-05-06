package problems;

import problems.util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 1, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if(node == null) return;
        if(res.size() < level) res.add(new ArrayList<>());
        res.get(level - 1).add(node.val);

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}

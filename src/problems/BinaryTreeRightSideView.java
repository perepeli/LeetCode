package problems;

import problems.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 1, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if(node == null) return;

        if(res.size() < level) {
            res.add(node.val);
        }
        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
    }
}

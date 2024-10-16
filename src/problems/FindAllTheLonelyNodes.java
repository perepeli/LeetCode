package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private boolean dfs(TreeNode node, List<Integer> res) {
        if(node == null) return false;

        boolean left = dfs(node.left, res);
        boolean right = dfs(node.right, res);

        if(left && !right) res.add(node.left.val);
        if(right && !left) res.add(node.right.val);

        return true;
    }
}

package problems;

import problems.util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        dfs(root, 1, map);

        int tempLevel = 1;

        while(map.containsKey(tempLevel)) {
            res.add(map.get(tempLevel));
            tempLevel++;
        }

        return res;
    }

    private void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if(node == null) return;

        if(!map.containsKey(level)) map.put(level, new ArrayList<>());
        map.get(level).add(node.val);

        dfs(node.left, level + 1, map);
        dfs(node.right, level + 1, map);
    }
}

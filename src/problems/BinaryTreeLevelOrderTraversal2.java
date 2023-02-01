package problems;

import problems.listnode.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        recursive(root, map, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(int key : map.keySet()) result.add(map.get(key));
        return result;
    }

    private void recursive(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        if (node == null) return;
        level++;

        if (!map.containsKey(level)) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(level, list);
        } else {
            map.get(level).add(node.val);
        }

        recursive(node.left, map, level);
        recursive(node.right, map, level);
    }
}

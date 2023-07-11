package problems;

import problems.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        recursive(root, 1, map);

        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private void recursive(TreeNode node, int level, Map<Integer, Integer> map) {
        if(node == null) return;

        map.put(level, node.val);

        recursive(node.left, level + 1, map);
        recursive(node.right, level + 1, map);

    }
}

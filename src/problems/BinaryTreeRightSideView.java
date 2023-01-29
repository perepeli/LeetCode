package problems;

import problems.listnode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        recursive(root, 0, map);

        List<Integer> out = new ArrayList<>();

        map.keySet().forEach(e -> {
            out.add(map.get(e).get(map.get(e).size()-1));
        });

        return out;
    }

    private void recursive(TreeNode node, int height, Map<Integer, List<Integer>> map) {
        if(node == null) return;

        if(!map.containsKey(height)) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(height, list);
        } else {
            map.get(height).add(node.val);
        }

        recursive(node.left, height + 1, map);
        recursive(node.right, height + 1, map);
    }
}

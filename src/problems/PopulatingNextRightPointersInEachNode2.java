package problems;

import java.util.HashMap;
import java.util.Map;

public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        if(root == null) return null;
        dfs(new HashMap<>(), root, 0);
        return root;
    }

    private void dfs(Map<Integer, Node> map, Node node, int level) {
        if(node == null) return;
        node.next = map.get(level);
        map.put(level, node);
        dfs(map, node.right, level + 1);
        dfs(map, node.left, level + 1);
    }
}

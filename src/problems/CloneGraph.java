package problems;


import problems.util.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        dfs(node, new HashSet<>(), map);
        return map.get(node);
    }

    private void dfs(Node node, Set<Node> visitSet, Map<Node, Node> map) {
        if(visitSet.contains(node)) return;
        visitSet.add(node);

        if(!map.containsKey(node)) map.put(node, new Node(node.val));

        System.out.println(node.val);

        for(Node e : node.neighbors) {
            if(!map.containsKey(e)) map.put(e, new Node(e.val));
            map.get(node).neighbors.add(map.get(e));

            dfs(e, visitSet, map);
        }
    }
}

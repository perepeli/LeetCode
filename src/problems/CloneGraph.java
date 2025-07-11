package problems;


import problems.util.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return deepCloneInternal(node, new HashMap<>());
    }

    private Node deepCloneInternal(Node node, Map<Node, Node> map) {
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);

        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);

        for(Node innerNode : node.neighbors) {
            clonedNode.neighbors.add(deepCloneInternal(innerNode, map));
        }

        return clonedNode;
    }
}

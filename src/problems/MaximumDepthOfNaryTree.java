package problems;

import java.util.List;

public class MaximumDepthOfNaryTree {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        return dfs(root);
    }

    private int dfs(Node node) {
        if(node == null) return 0;

        int res = 0;

        for(Node n : node.children) {
            res = Math.max(res, dfs(n));
        }

        return 1 + res;
    }
}

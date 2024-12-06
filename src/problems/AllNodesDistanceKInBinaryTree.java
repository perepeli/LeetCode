package problems;

import problems.util.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        buildAdjList(root, null, adjList);
        List<Integer> res = new ArrayList<>();
        if(adjList.containsKey(target.val)) dfs(adjList, new HashSet<>(), target.val, k, res);
        return res;
    }

    private void dfs(Map<Integer, Set<Integer>> adjList, Set<Integer> visited, Integer node, int depth, List<Integer> res) {
        if(visited.contains(node)) return;
        visited.add(node);
        if(depth < 0) return;
        else if(depth == 0) res.add(node);
        else {
            for(int i : adjList.get(node)) {
                dfs(adjList, visited, i, depth - 1, res);
            }
        }
    }

    private void buildAdjList(TreeNode node, TreeNode parent, Map<Integer, Set<Integer>> adjList) {
        if(node == null) return;

        adjList.put(node.val, new HashSet<>());

        if(node.left != null) adjList.get(node.val).add(node.left.val);
        if(node.right != null) adjList.get(node.val).add(node.right.val);
        if(parent != null) adjList.get(node.val).add(parent.val);

        buildAdjList(node.left, node, adjList);
        buildAdjList(node.right, node, adjList);
    }
}

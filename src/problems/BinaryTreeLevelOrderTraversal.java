package problems;

import problems.util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(TreeNode root) { // dfs solution
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        recursive(root, 1, levels);
        return levels;
    }

    private void recursive(TreeNode node, int level, List<List<Integer>> levels) {
        if(levels.size() < level) levels.add(new ArrayList<>());
        levels.get(level-1).add(node.val);


        if(node.left != null) recursive(node.left, level + 1, levels);
        if(node.right != null) recursive(node.right, level + 1, levels);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) { // bfs iterative
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<AbstractMap.SimpleEntry<Integer, TreeNode>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(1, root));

        while(!queue.isEmpty()) {
            var pair = queue.poll();
            int key = pair.getKey();
            TreeNode node = pair.getValue();

            if(node == null) continue;

            if(map.containsKey(key)) {
                map.get(key).add(node.val);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(node.val);
                map.put(key, newList);
            }

            queue.add(new AbstractMap.SimpleEntry<>(key + 1, node.left));
            queue.add(new AbstractMap.SimpleEntry<>(key + 1, node.right));
        }

        return new ArrayList<>(map.values());
    }
}

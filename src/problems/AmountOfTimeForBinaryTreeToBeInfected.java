package problems;

import problems.util.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if(!adjList.containsKey(node.val)) adjList.put(node.val, new HashSet<>());

            if(node.left != null) {
                adjList.get(node.val).add(node.left.val);
                if(!adjList.containsKey(node.left.val)) adjList.put(node.left.val, new HashSet<>());
                adjList.get(node.left.val).add(node.val);
                stack.push(node.left);
            }

            if(node.right != null) {
                adjList.get(node.val).add(node.right.val);
                if(!adjList.containsKey(node.right.val)) adjList.put(node.right.val, new HashSet<>());
                adjList.get(node.right.val).add(node.val);
                stack.push(node.right);
            }
        }


        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        int minute = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize > 0) {
                int curr = queue.poll();
                for(int num : adjList.get(curr)) {
                    if(!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            minute++;
        }



        return minute - 1;
    }
}

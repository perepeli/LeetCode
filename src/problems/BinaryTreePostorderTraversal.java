package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //recursive(root, res);
        iterative(root, res);
        return res;
    }

    private void recursive(TreeNode node, List<Integer> res) { // recursive approach
        if(node == null) return;

        recursive(node.left, res);
        recursive(node.right, res);
        res.add(node.val);
    }

    private void iterative(TreeNode node, List<Integer> res) { // iterative approach
        Deque<TreeNode> stack = new LinkedList<>();
    }
}

package problems;

import problems.listnode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //recursive(root, result);
        iterative(root, result);
        return result;
    }

    private void recursive(TreeNode node, List<Integer> res) { // recursive approach
        if(node == null) return;

        res.add(node.val);
        recursive(node.left, res);
        recursive(node.right, res);
    }

    private void iterative(TreeNode node, List<Integer> res) { // iterative approach
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();

            if(tempNode != null) {
                //System.out.println(tempNode.val);
                res.add(tempNode.val);
                stack.add(tempNode.right);
                stack.add(tempNode.left);
            }
        }
    }
}

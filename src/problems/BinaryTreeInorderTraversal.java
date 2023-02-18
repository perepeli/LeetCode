package problems;

import problems.listnode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode node, List<Integer> result) {
        if(node == null) return;

        recursive(node.left, result);
        result.add(node.val);
        recursive(node.right, result);
    }
}

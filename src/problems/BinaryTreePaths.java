package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        backtrack(root, new ArrayList<>(), res);
        return res.stream().map(e -> String.join("->", e)).toList();
    }

    private void backtrack(TreeNode node, List<String> temp, List<List<String>> res) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            temp.add(String.valueOf(node.val));
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }

        if(node.left != null) {
            temp.add(String.valueOf(node.val));
            backtrack(node.left, temp, res);
            temp.remove(temp.size() - 1);
        }

        if(node.right != null) {
            temp.add(String.valueOf(node.val));
            backtrack(node.right, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}

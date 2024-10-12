package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        for(int i = list.size() - 1; i >= 0; i--) {
            list.get(i).left = null;
            if(i != list.size() - 1) list.get(i).right = list.get(i + 1);
        }

        return list.get(0);
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if(node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
}

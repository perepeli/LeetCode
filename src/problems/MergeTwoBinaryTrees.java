package problems;

import problems.util.TreeNode;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return null;

        TreeNode node = new TreeNode();
        if(node1 != null) node.val += node1.val;
        if(node2 != null) node.val += node2.val;

        TreeNode node1Left = node1 != null ? node1.left : null;
        TreeNode node1Right = node1 != null ? node1.right : null;
        TreeNode node2Left = node2 != null ? node2.left : null;
        TreeNode node2Right = node2 != null ? node2.right : null;

        merge(node1Left, node2Left, node, true);
        merge(node1Right, node2Right, node, false);

        return node;
    }

    private void merge(TreeNode node1, TreeNode node2, TreeNode parent, boolean isLeft) {
        if(node1 == null && node2 == null) return;

        TreeNode node = new TreeNode();
        if(node1 != null) node.val += node1.val;
        if(node2 != null) node.val += node2.val;

        TreeNode node1Left = node1 != null ? node1.left : null;
        TreeNode node1Right = node1 != null ? node1.right : null;
        TreeNode node2Left = node2 != null ? node2.left : null;
        TreeNode node2Right = node2 != null ? node2.right : null;

        if(isLeft) parent.left = node;
        else parent.right = node;

        merge(node1Left, node2Left, node, true);
        merge(node1Right, node2Right, node, false);
    }
}

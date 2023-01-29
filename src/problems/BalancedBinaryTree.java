package problems;

import problems.listnode.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return recursive(root).isBalanced;
    }

    private Pair recursive(TreeNode root) {
        if(root == null) return new Pair(-1, true);

        Pair left = recursive(root.left);
        if(!left.isBalanced) return new Pair(-1, false);

        Pair right = recursive(root.right);
        if(!right.isBalanced) return new Pair(-1, false);

        if(Math.abs(left.height - right.height) < 2) return new Pair(Math.max(left.height, right.height) + 1, true);
        return new Pair(-1, false);
    }
}

class Pair {
    public final boolean isBalanced;
    public final int height;

    public Pair(int height, boolean isBalanced) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

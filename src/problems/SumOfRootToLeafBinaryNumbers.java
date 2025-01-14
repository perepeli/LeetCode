package problems;

import problems.util.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

    private int rootToLeaf;

    public int sumRootToLeaf(TreeNode root) {
        rootToLeaf = 0;
        dfs(root, 0);
        return rootToLeaf;
    }

    private void dfs(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = (currNumber << 1) | r.val;
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            dfs(r.left, currNumber);
            dfs(r.right, currNumber);
        }
    }
}

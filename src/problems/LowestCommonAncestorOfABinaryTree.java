package problems;

import problems.util.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Object[] res = dfs(root, p.val, q.val);
        return (TreeNode) res[2];
    }

    private Object[] dfs(TreeNode root, int p, int q) {
        if(root == null) return new Object[]{false, false, null};

        Object[] leftRes = dfs(root.left, p, q);
        boolean LL = (boolean) leftRes[0];
        boolean LR = (boolean) leftRes[1];

        if(LL && LR) return leftRes;
        if(root.val == p || root.val == q) {
            if(LL || LR) return new Object[]{true, true, root};
        }

        Object[] rightRes = dfs(root.right, p, q);
        boolean RL = (boolean) rightRes[0];
        boolean RR = (boolean) rightRes[1];

        if(RL && RR) return rightRes;
        if(root.val == p || root.val == q) {
            if(RL || RR) return new Object[]{true, true, root};
        }

        if((LL || LR) && (RL || RR)) return new Object[]{true, true, root};
        if(LL || LR) return new Object[]{true, false, null};
        if(RL || RR) return new Object[]{false, true, null};

        if(root.val == p || root.val == q) return new Object[]{true, false, null};

        return new Object[]{false, false, null};
    }
}

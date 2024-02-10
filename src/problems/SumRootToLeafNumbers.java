package problems;

import problems.util.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[]{0};
        dfs(root, new StringBuilder(), res);
        return res[0];
    }

    private void dfs(TreeNode node, StringBuilder sb, int[] res) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            if(node.val == 0 && sb.length() == 0) {
                return;
            } else {
                sb.append(node.val);
                res[0] += Integer.parseInt(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            if(node.val == 0 && sb.length() == 0) {
                dfs(node.left, sb, res);
                dfs(node.right, sb, res);
            } else {
                sb.append(node.val);
                dfs(node.left, sb, res);
                dfs(node.right, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

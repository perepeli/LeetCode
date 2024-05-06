package problems;

import problems.util.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1 = new StringBuilder();
        serializeInternal(root, sb1);

        StringBuilder sb2 = new StringBuilder();
        serializeInternal(subRoot, sb2);

        return sb1.toString().contains(sb2.toString());
    }

    private void serializeInternal(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
        } else {
            sb.append("|");
            sb.append(node.val);
            sb.append("|");
            sb.append(',');
            serializeInternal(node.left, sb);
            serializeInternal(node.right, sb);
        }
    }
}

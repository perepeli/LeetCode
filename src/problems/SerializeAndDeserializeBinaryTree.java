package problems;

import problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeInternal(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void serializeInternal(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val);
            sb.append(',');
            serializeInternal(node.left, sb);
            serializeInternal(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        Deque<String> queue = new LinkedList<>();
        for(String token : tokens) queue.addLast(token);
        return deserializeInternal(queue);
    }

    private TreeNode deserializeInternal(Deque<String> queue) {
        String curr = queue.removeFirst();

        if("null".equals(curr)) {
            return null;
        } else {
            TreeNode currNode = new TreeNode();
            currNode.val = Integer.parseInt(curr);
            currNode.left = deserializeInternal(queue);
            currNode.right = deserializeInternal(queue);
            return currNode;
        }
    }
}

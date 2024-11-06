package problems;

import problems.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> inorderIndexMap;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        for(int i = 0; i < inorder.length; i++) inorderIndexMap.put(inorder[i], i);
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(preorderIndex >= preorder.length) return null;
        if(left > right) return null;

        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int index = inorderIndexMap.get(node.val);

        if(left != index) {
            preorderIndex++;
            node.left = arrayToTree(preorder, left, index - 1);
        }

        if(right != index) {
            preorderIndex++;
            node.right = arrayToTree(preorder,index + 1, right);
        }

        return node;
    }
}

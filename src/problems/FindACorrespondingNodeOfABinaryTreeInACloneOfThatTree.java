package problems;

import problems.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> stackOriginal = new ArrayDeque<>();
        Deque<TreeNode> stackCloned = new ArrayDeque<>();

        stackOriginal.push(original);
        stackCloned.push(cloned);

        while(!stackOriginal.isEmpty()) {
            TreeNode originalNode = stackOriginal.pop();
            TreeNode clonedNode = stackCloned.pop();

            if(originalNode == target) return clonedNode;

            if(originalNode.left != null) {
                stackOriginal.push(originalNode.left);
                stackCloned.push(clonedNode.left);
            }

            if(originalNode.right != null) {
                stackOriginal.push(originalNode.right);
                stackCloned.push(clonedNode.right);
            }

        }

        return null;
    }
}

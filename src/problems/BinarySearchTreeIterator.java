package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    public static class BSTIterator {
        private List<Integer> inorder;
        private int index;

        public BSTIterator(TreeNode root) {
            inorder = new ArrayList<>();
            index = 0;
            populateList(root);
        }

        private void populateList(TreeNode node) {
            if(node == null) return;
            populateList(node.left);
            inorder.add(node.val);
            populateList(node.right);
        }

        public int next() {
            return inorder.get(index++);
        }

        public boolean hasNext() {
            return index < inorder.size();
        }
    }
}

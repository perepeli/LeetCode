package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode res = null;

        recursive(root, p, list);
        int counter = 0;

        for(int i = 0; i < list.size(); i++) {
            if(counter == 1) {
                res = list.get(i);
                break;
            }
            if(list.get(i) == p) counter ++;
        }

        return res;
    }

    private void recursive(TreeNode root, TreeNode p, List<TreeNode> list) {
        if(root == null) return;

        recursive(root.left, p, list);
        list.add(root);
        recursive(root.right, p, list);
    }
}

package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum5InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            int sum = list.get(left) + list.get(right);
            if(sum < k) {
                left++;
            } else if(sum > k) {
                right--;
            } else {
                return true;
            }
        }

        return false;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if(node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}

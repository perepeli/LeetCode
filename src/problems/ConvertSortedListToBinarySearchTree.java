package problems;

import problems.util.ListNode;
import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    private List<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        return recursive(0, list.size() - 1);
    }

    private TreeNode recursive(int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(list.get(mid));

        node.left = recursive(left, mid - 1);
        node.right = recursive(mid + 1, right);

        return node;
    }
}

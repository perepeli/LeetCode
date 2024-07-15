package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafNodesPairs {
    public int countPairs(TreeNode root, int distance) {
        int[] res = new int[]{0};
        dfs(root, distance, 0, res);
        return res[0];
    }

    private List<int[]> dfs(TreeNode node, int distance, int depth, int[] res) {
        List<int[]> ret = new ArrayList<>();
        if(node == null) return ret;
        if(node.left == null && node.right == null) {
            ret.add(new int[]{node.val, depth});
            return ret;
        }

        List<int[]> leftResult = dfs(node.left, distance, depth + 1, res);
        List<int[]> rightResult = dfs(node.right, distance, depth + 1, res);

        for(int[] left : leftResult) {
            for(int[] right : rightResult) {
                int leftToRightDistance = (left[1] - depth) + (right[1] - depth);
                if(leftToRightDistance <= distance) res[0]++;
            }
        }

        ret.addAll(leftResult);
        ret.addAll(rightResult);

        return ret;
    }
}

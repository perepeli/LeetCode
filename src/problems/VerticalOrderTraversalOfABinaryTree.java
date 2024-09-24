package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> res = new ArrayList<>();
        dfs(root, 0, 0, res);

        Collections.sort(res, (int[] a, int[] b) -> a[2] - b[2] == 0 ? a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1] : a[2] - b[2]);
        res.forEach(arr -> System.out.println(Arrays.toString(arr)));

        List<List<Integer>> finalRes = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < res.size(); i++) {
            if(i > 0 && res.get(i - 1)[2] == res.get(i)[2]) {
                temp.add(res.get(i)[0]);
            } else {
                if(i != 0) finalRes.add(temp);
                temp = new ArrayList<>();
                temp.add(res.get(i)[0]);
            }
        }
        if(!temp.isEmpty()) finalRes.add(temp);

        return finalRes;
    }

    private void dfs(TreeNode node, int depth, int distance, List<int[]> res) {
        if(node == null) return;
        res.add(new int[]{node.val, depth, distance});
        dfs(node.left, depth + 1, distance - 1, res);
        dfs(node.right, depth + 1, distance + 1, res);
    }
}

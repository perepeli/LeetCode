package problems;

import problems.listnode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Double>> map = new HashMap<>();
        recursive(root, 0, map);

        List<Double> out = new ArrayList<>();

        for(List<Double> list : map.values()) {
            int length = list.size();
            double sum = 0;
            for(double e : list) {
                sum += e;
            }
            out.add(sum/length);
        }

        return out;
    }

    private void recursive(TreeNode node, int level, Map<Integer, List<Double>> map) {
        if(node == null) return;
        level++;
        if(!map.containsKey(level)) {
            List<Double> newList = new ArrayList<>();
            newList.add((double)node.val);
            map.put(level, newList);
        } else {
            map.get(level).add((double)node.val);
        }
        recursive(node.left, level, map);
        recursive(node.right, level, map);
    }
}

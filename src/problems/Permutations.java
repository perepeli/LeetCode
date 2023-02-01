package problems;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(nums, nums.length, new LinkedHashSet<>(), result);
        return result;
    }

    private void recursive(int[] arr, int depth, Set<Integer> excludeSet, List<List<Integer>> result) {
        if(depth == 0) {
            result.add(excludeSet.stream().toList());
            return;
        }

        for(int i: arr) {
            if(!excludeSet.contains(i)) {
                Set<Integer> newSet = new LinkedHashSet<>(excludeSet);
                newSet.add(i);

                recursive(arr, depth - 1, newSet, result);
            }
        }
    }
}

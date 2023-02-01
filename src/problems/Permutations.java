package problems;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(nums, nums.length, new ArrayList<>(), result);
        return result;
    }

    private void recursive(int[] arr, int depth, List<Integer> permutation, List<List<Integer>> result) {
        if(depth == 0) {
            result.add(permutation);
            return;
        }

        for(int i: arr) {
            if(!permutation.contains(i)) {
                List<Integer> newList = new ArrayList<>(permutation);
                newList.add(i);

                recursive(arr, depth - 1, newList, result);
            }
        }
    }
}

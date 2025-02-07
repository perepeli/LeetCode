package problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {
    public int[][] permute(int n) {
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++) nums[i] = i + 1;

        boolean[] used = new boolean[n];

        List<List<Integer>> permutations = new ArrayList<>();

        backtrack(nums, used, new ArrayList<>(), permutations);

        int[][] result = new int[permutations.size()][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = permutations.get(i).get(j);
            }
        }

        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(!used[i]) {
                    if(temp.size() == 0 || (temp.get(temp.size() - 1) % 2 != nums[i] % 2)) {
                        used[i] = true;
                        temp.add(nums[i]);
                        backtrack(nums, used, temp, res);
                        temp.remove(temp.size() - 1);
                        used[i] = false;
                    }
                }
            }
        }
    }
}

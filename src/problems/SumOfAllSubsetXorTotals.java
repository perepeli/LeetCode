package problems;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXorTotals {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);

        Integer res = list.stream()
                .map(e -> e.stream().reduce((x, y) -> x ^ y).orElse(0))
                .reduce(0, Integer::sum);

        return res;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

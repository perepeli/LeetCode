package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
    private int[] nums;

    private Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (this.nums[i] == target) {
                indices.add(i);
            }
        }
        int l = indices.size();
        int randomIndex = indices.get(rand.nextInt(l));
        return randomIndex;
    }
}

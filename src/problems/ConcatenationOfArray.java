package problems;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int max = length*2;
        int middle = max/2;
        int[] ans = new int[max];

        for (int i = 0; i < middle; i++) {
            ans[i] = nums[i];
            ans[middle + i] = nums[i];
        }

        return ans;
    }
}

package problems;

public class SpecialArray2 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] parity = new int[nums.length];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] % 2 + nums[i - 1] % 2 == 1) {
                parity[i] = parity[i - 1];
            } else {
                parity[i] = parity[i - 1] + 1;
            }
        }

        boolean[] res = new boolean[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int from = query[0];
            int to = query[1];
            res[i] = parity[from] == parity[to];
        }

        return res;
    }
}

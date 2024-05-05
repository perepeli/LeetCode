package problems;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(num < 0) {
                res[negativeIndex] = num;
                negativeIndex += 2;
            } else {
                res[positiveIndex] = num;
                positiveIndex += 2;
            }
        }

        return res;
    }
}

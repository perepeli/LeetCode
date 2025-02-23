package problems;

public class FindTriangularSumOfAnArray {
    public int triangularSum(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < temp.length; i++) temp[i] = nums[i];
        int len = nums.length;

        while(len-- > 0) {
            for(int i = 0; i < len; i++) {
                temp[i] = (temp[i] + temp[i + 1]) % 10;
            }
        }
        return temp[0];
    }
}

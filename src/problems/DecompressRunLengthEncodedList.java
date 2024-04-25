package problems;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for(int i = 0; i < nums.length; i += 2) {
            length += nums[i];
        }

        int[] res = new int[length];

        int index = 0;

        for(int i = 1; i < nums.length; i += 2) {
            int count = nums[i - 1];
            int num = nums[i];

            for(int j = 0; j < count; j++) {
                res[index++] = num;
            }
        }

        return res;
    }
}

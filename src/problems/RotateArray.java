package problems;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];

        for(int i = 0; i < nums.length; i++) {

            temp[(i + k) % len] = nums[i];
        }

        for(int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}

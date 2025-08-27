package problems;

public class CheckIfItIsAGoodArray {

    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        for(int i = 1;i < nums.length; i++){
            result = GCD(nums[i],result);
        }
        return result == 1;
    }

    static int GCD(int i, int j){
        if(j == 0) return i;
        return GCD(j, i%j);
    }
}

package problems;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int[] prefix = new int[length];
        int[] postfix = new int[length];

        int prefixRunningProduct = 1;
        for(int i = 0; i < length; i++) {
            prefix[i] = prefixRunningProduct;
            prefixRunningProduct *= nums[i];
        }

        int postfixRunningProduct = 1;
        for(int i = length-1; i >= 0; i--) {
            postfix[i] = postfixRunningProduct;
            postfixRunningProduct *= nums[i];
        }

        for(int i = 0; i < length; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }
}

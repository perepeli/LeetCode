package problems;

public class TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        // 1 2 3 4 5 7, t=12
        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];

            if(sum == target) return new int[]{left + 1, right + 1};

            if(sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}

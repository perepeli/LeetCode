package problems;

public class SumOfDigitsInTheMinimumNumber {
    public int sumOfDigits(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int ans = 0;

        while (min > 0) {
            ans += min % 10;
            min /= 10;
        }

        return 1 - ans % 2;
    }
}

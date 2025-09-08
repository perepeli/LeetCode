package problems;

public class NumberOfBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] firstDigits = new int[n];
        for (int i = 0; i < n; i++) {
            firstDigits[i] = getFirstDigit(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int firstDigit = firstDigits[i];
                int lastDigit = nums[j] % 10;
                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

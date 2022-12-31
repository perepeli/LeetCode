package problems;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums)
            if(digits(n) % 2 == 0)
                ++count;
        return count;
    }
    private int digits(int n){
        int digits = 0;
        while(n > 0){
            ++digits;
            n/=10;
        }
        return digits;
    }
}

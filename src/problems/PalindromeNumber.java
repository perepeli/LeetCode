package problems;

public class PalindromeNumber {
    public boolean isPalindrome(int number) {
        if (number < 0) return false;
        final int fNumber = number;
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10;
            reversed = reversed + number % 10;
            number = number / 10;
        }
        return reversed == fNumber;
    }
}

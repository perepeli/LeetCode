package problems;

public class DivideTwoIntegers {
    private static int HALF_INT_MIN = -1073741824;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int highestDouble = divisor;
        int highestPowerOfTwo = -1;
        while (
                highestDouble >= HALF_INT_MIN &&
                        dividend <= highestDouble + highestDouble
        ) {
            highestPowerOfTwo += highestPowerOfTwo;
            highestDouble += highestDouble;
        }

        int quotient = 0;
        while (dividend <= divisor) {
            if (dividend <= highestDouble) {
                quotient += highestPowerOfTwo;
                dividend -= highestDouble;
            }

            highestPowerOfTwo >>= 1;
            highestDouble >>= 1;
        }

        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}

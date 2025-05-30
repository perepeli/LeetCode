package problems;

public class ConfusingNumber {
    public boolean confusingNumber(int n) {
        int digits = n;
        int result = 0;
        while (digits > 0) {
            int d = digits % 10;
            if (isValid(d)) {
                result = 10 * result + rotate(d);
            } else {
                return false;
            }
            digits /= 10;
        }

        return result == n ? false : true;
    }

    private boolean isValid(int n) {
        if ((n >= 2 && n <= 5) || n== 7) return false;

        return true;
    }

    private int rotate(int n) {
        if (n == 9) return 6;
        if (n == 6) return 9;

        return n;
    }
}

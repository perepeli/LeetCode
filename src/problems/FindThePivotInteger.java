package problems;

public class FindThePivotInteger {
    public int pivotInteger(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        int right = sum;
        int left = 0;

        for(int i = 1; i <= n; i++) {
            left += i;
            if(left == right) {
                return i;
            }
            right -= i;
        }
        return -1;
    }
}

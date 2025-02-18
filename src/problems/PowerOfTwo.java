package problems;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        long mask = (long) n & (-n);
        return mask == (long) n;
    }
}

package problems;

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        return n + (n % 2) * n;
    }
}

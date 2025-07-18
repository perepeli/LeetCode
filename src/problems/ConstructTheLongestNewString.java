package problems;

public class ConstructTheLongestNewString {
    public int longestString(int x, int y, int z) {
        int min = Math.min(x, y);

        if (x == y) {
            return (4 * x + 2 * z);
        } else {
            return (2 * min + (min + 1) * 2 + 2 * z);
        }
    }
}

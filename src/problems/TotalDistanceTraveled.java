package problems;

public class TotalDistanceTraveled {
    public int distanceTraveled(int a, int b) {
        return (a + Math.min((a - 1) / 4, b)) * 10;
    }
}

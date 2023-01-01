package problems;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int ops = 0;
        int leftBalls = 0;
        int rightBalls = 0;
        for(int i = 0; i < n; i++) {
            char box = boxes.charAt(i);
            if(box == '1')  {
                ops += (i - 0);
                rightBalls++;
            }
        }
        for(int i = 0; i < n; i++) {
            res[i] = ops;
            char box = boxes.charAt(i);
            if(box == '1') {
                leftBalls++;
                rightBalls--;
            }
            ops -=  rightBalls;
            ops += leftBalls;
        }
        return res;
    }
}

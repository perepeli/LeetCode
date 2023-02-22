package problems;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {

        int result = numBottles;

        while(numBottles / numExchange > 0) {
            int newBottles = numBottles / numExchange;
            numBottles -= newBottles * numExchange;

            result += newBottles;
            numBottles += newBottles;
        }

        return result;
    }
}

package problems;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int moneyLeft = coins;
        int iceCreams = 0;

        for(int i = 0; i < costs.length; i++) {
            if(costs[i] <= moneyLeft) {
                moneyLeft-=costs[i];
                iceCreams++;
            } else {
                break;
            }
        }

        return iceCreams;
    }
}

package problems;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int res = 0;

        int left = 0;
        int right = 1;

        while(right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];

            if(sell - buy > 0) {
                res += sell - buy;
            }
            left++;
            right++;
        }

        return res;
    }
}

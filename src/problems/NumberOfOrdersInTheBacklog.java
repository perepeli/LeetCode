package problems;

import java.util.PriorityQueue;

public class NumberOfOrdersInTheBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyMax = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellMin = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] order : orders) {
            int type = order[2];
            int price = order[0];
            int amount = order[1];

            if(amount < 1) continue;

            if(type == 1) { // sell
                while(amount > 0 && !buyMax.isEmpty() && buyMax.peek()[0] >= price) {
                    int[] buyOrder = buyMax.poll();
                    int minBuy = Math.min(amount, buyOrder[1]);
                    buyOrder[1] -= minBuy;
                    amount -= minBuy;
                    if(buyOrder[1] > 0) buyMax.offer(buyOrder);
                }
                if(amount > 0) sellMin.offer(new int[]{price, amount, type});
            } else { // buy
                while(amount > 0 && !sellMin.isEmpty() && sellMin.peek()[0] <= price) {
                    int[] sellOrder = sellMin.poll();
                    int minSell = Math.min(amount, sellOrder[1]);
                    sellOrder[1] -= minSell;
                    amount -= minSell;
                    if(sellOrder[1] > 0) sellMin.offer(sellOrder);
                }
                if(amount > 0) buyMax.offer(new int[]{price, amount, type});
            }
        }

        int res = 0;
        int MOD = 1_000_000_007;

        for(int[] order : buyMax) res = (res + order[1]) % MOD;
        for(int[] order : sellMin) res = (res + order[1]) % MOD;

        return (int) res;
    }
}

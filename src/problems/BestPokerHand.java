package problems;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        for(int i = 1; i < suits.length; i++) {
            if(suits[i] != suits[i - 1]) break;
            if(i == suits.length - 1) return "Flush";
        }

        int[] count = new int[13];

        for(int i = 0; i < ranks.length; i++) {
            count[ranks[i] - 1]++;
        }

        int pairRank = -1;

        for(int i = 0; i < count.length; i++) {
            if(count[i] >= 3) return "Three of a Kind";
            if(count[i] == 2) pairRank = i + 1;
        }

        if(pairRank != -1) return "Pair";

        return "High Card";
    }
}

package problems;

public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int[] prefix = new int[customers.length() + 1];
        int[] suffix = new int[customers.length() + 1];

        for(int i = customers.length() - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if(customers.charAt(i) == 'Y') {
                suffix[i]++;
            }
        }

        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1];
            if(customers.charAt(i - 1) == 'N') {
                prefix[i]++;
            }
        }

        int minPenalty = Integer.MAX_VALUE;
        int minHour = 0;

        for(int i = 0; i < prefix.length; i++) {
            int penalty = prefix[i] + suffix[i];
            if(penalty < minPenalty) {
                minPenalty = penalty;
                minHour = i;
            }
        }
        return minHour;
    }
}

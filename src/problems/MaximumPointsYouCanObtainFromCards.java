package problems;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int minWindow = Integer.MAX_VALUE;

        for(int i : cardPoints) {
            total += i;
        }

        int window = cardPoints.length - k;
        int tempWindowSum = 0;

        int left = 0;
        int right = left;

        while(right < cardPoints.length) {
            if(window > 0) {
                window--;
                tempWindowSum += cardPoints[right++];
            } else {
                minWindow = Math.min(minWindow, tempWindowSum);
                tempWindowSum -= cardPoints[left++];
                tempWindowSum += cardPoints[right++];
            }
        }

        minWindow = Math.min(minWindow, tempWindowSum);

        return total - minWindow;
    }
}

package problems;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        int result = 0;

        for(int i = 0; i < ratings.length; i++) {
            result += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return result;
    }
}

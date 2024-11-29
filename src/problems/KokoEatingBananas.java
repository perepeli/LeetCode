package problems;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = Integer.MIN_VALUE;
        for(int i : piles) max = Math.max(max, i);

        int right = max;
        int left = 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEat(int[] piles, int speed, int h) {
        for(int i : piles) {
            h -= (int) Math.ceil((double) i / speed);
            if(h < 0) return false;
        }
        return true;
    }
}

package problems;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for(int i : piles) {
            maxSpeed = Math.max(maxSpeed, i);
        }

        int left = 1;
        int right = maxSpeed;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canFinish(piles, h, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int totalHoursWasted = 0;
        for(int i : piles) {
            int hoursWasted = (i + speed - 1) / speed;
            totalHoursWasted += hoursWasted;
            if(totalHoursWasted > h) return false;
        }
        return true;
    }
}

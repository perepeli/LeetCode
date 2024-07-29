package problems;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = left;
        for(int i : piles) right = Math.max(right, i);

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canEatWithin(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEatWithin(int[] piles, int hours, int items) {
        int tempHours = 0;

        for(int i : piles) {
            tempHours += (int) Math.ceil((double) i / (double) items);
            if(tempHours > hours) return false;
        }
        return true;
    }
}

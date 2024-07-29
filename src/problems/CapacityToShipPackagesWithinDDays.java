package problems;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }

        int left = max;
        int right = sum;

        while(left < right) {
            int mid = (left + right) / 2;

            if(checkCanBeShipped(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean checkCanBeShipped(int[] weights, int days, int maxLoad) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for(int weight : weights) {
            currentLoad += weight;
            if(currentLoad > maxLoad) {
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }
}

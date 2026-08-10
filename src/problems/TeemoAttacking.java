package problems;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalPoisonDuration = duration;
        int prevAttack = timeSeries[0];

        for(int i = 1; i < timeSeries.length; i++) {
            int newAttack = timeSeries[i];
            boolean overlap = newAttack <= (prevAttack + duration - 1);

            if(overlap) {
                int sharedDuration = (prevAttack + duration) - newAttack;
                totalPoisonDuration += duration - (sharedDuration);
            } else {
                totalPoisonDuration += duration;
            }

            prevAttack = timeSeries[i];
        }

        return totalPoisonDuration;
    }
}

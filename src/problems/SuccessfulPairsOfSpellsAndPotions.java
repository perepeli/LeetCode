package problems;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);

        for(int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;

            while(left < right) {
                int mid = left + (right - left) / 2;
                if((long)potions[mid] * spells[i] >= success) right = mid;
                else left = mid + 1;
            }

            if((long)spells[i] * potions[left] >= success) {
                res[i] = potions.length - left;
            }
        }

        return res;
    }
}

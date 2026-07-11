package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomPickWithBlacklist {
    HashMap<Integer,Integer> map;
    int poolLen;
    Random seed;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        Arrays.sort(blacklist);
        this.seed = new Random();
        this.map = new HashMap<>();
        this.poolLen = n - blacklist.length;

        int poolEnd = n-1;
        for (int i = blacklist.length-1; i >= 0; i--) {
            final int val = blacklist[i];

            if (!this.map.containsKey(poolEnd)) {
                this.map.put(val, poolEnd);
            } else {
                this.map.put(val, this.map.get(poolEnd));
                this.map.remove(poolEnd);
            }
            poolEnd--;
        }
    }

    public int pick() {
        int i = this.seed.nextInt(this.poolLen);
        if (this.map.containsKey(i)) {
            return this.map.get(i);
        }

        return i;
    }
}

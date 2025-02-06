package problems;

public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int p = Integer.MAX_VALUE;
        int res = 1;

        for(int i = 1; i < colors.length; i++) {
            if(colors[i] != colors[0]) {
                p = Math.min(p, i);
                res = i;
            } else {
                res = Math.max(res, i - p);
            }
        }

        return res;
    }
}

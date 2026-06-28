package problems;

public class StoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        if (stones.length == 1) {
            return false;
        }
        int one = 0;
        int two = 0;
        int three = 0;
        for (int stone : stones) {
            if (stone % 3 == 1) {
                one++;
            } else if (stone % 3 == 2) {
                two++;
            } else {
                three++;
            }
        }
        if (three % 2 == 0) {
            return one != 0 && two != 0;
        } else {
            return (one >= 3 && two == 0) || (two >= 3 && one == 0)
                    || (Math.abs(one - two) >= 3);
        }
    }
}

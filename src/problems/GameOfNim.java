package problems;

public class GameOfNim {
    public boolean nimGame(int[] piles) {
        int nimSum = 0;

        for (int p : piles) {
            nimSum ^= p;
        }

        return nimSum != 0;
    }
}

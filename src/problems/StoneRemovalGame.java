package problems;

public class StoneRemovalGame {
    public boolean canAliceWin(int n) {
        boolean turn = false;
        int p = 10;

        while (n >= p) {
            n -= p;
            p -= 1;
            turn = !turn;
        }

        return turn;
    }
}

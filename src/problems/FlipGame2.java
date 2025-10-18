package problems;

public class FlipGame2 {
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() < 2) {
            return false;
        }

        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.startsWith("++", i)) {
                String t = currentState.substring(0, i) + "--" + currentState.substring(i + 2);

                if (!canWin(t)) {
                    return true;
                }
            }
        }

        return false;
    }
}

package problems;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) {
            return false;
        }

        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWinHelper(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean canIWinHelper(int maxChoosableInteger, int desiredTotal, int usedNumbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(usedNumbers)) {
            return memo.get(usedNumbers);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int currentBit = 1 << i;
            if ((usedNumbers & currentBit) == 0) {
                if (desiredTotal - i <= 0 ||
                        !canIWinHelper(maxChoosableInteger, desiredTotal - i, usedNumbers | currentBit, memo)) {
                    memo.put(usedNumbers, true);
                    return true;
                }
            }
        }

        memo.put(usedNumbers, false);
        return false;
    }
}

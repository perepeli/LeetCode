package problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        for(int hours = 0; hours < 12; hours++) {
            for(int minutes = 0; minutes < 60; minutes++) {

                if(isMatch(hours, minutes, turnedOn)) {
                    res.add(convertToStringTime(hours, minutes));
                }
            }
        }

        return res;
    }

    private boolean isMatch(int hours, int minutes, int turnedOn) {
        int currentlyTurnedOn = 0;

        for(int i = 1; i <= 8; i *= 2) {
            if((i & hours) > 0) {
                currentlyTurnedOn++;
            }
        }

        for(int i = 1; i <= 32; i *= 2) {
            if((i & minutes) > 0) {
                currentlyTurnedOn++;
            }
        }

        return currentlyTurnedOn == turnedOn;
    }

    private String convertToStringTime(int hours, int minutes) {
        StringBuilder sb = new StringBuilder();

        sb.append(hours);

        sb.append(':');

        if(minutes < 10) sb.append('0');
        sb.append(minutes);

        return sb.toString();
    }
}

package problems;

public class NumberOfValidClockTimes {
    public int countTime(String time) {
        int multiplier = 1;

        if(time.charAt(0) == '?' && time.charAt(1) == '?') multiplier *= 24;
        else if(time.charAt(0) == '?') {
            if((time.charAt(1) - '0') < 4) multiplier *= 3;
            else multiplier *= 2;
        } else if(time.charAt(1) == '?') {
            if((time.charAt(0) - '0') < 2) multiplier *= 10;
            else multiplier *= 4;
        }
        if(time.charAt(3) == '?') multiplier *= 6;
        if(time.charAt(4) == '?') multiplier *= 10;

        return multiplier;
    }
}

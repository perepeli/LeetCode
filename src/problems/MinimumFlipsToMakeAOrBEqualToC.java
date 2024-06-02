package problems;

public class MinimumFlipsToMakeAOrBEqualToC {
    public int minFlips(int a, int b, int c) {
        int mask = 1;
        int res = 0;
        int endMask = 1 << 31;

        while(true) {
            int C = mask & c;

            if(C > 0) {
                if((a & C) == 0 && (b & C) == 0) res++;
            } else {
                if((mask & a) > 0) res++;
                if((mask & b) > 0) res++;
            }

            if(mask == endMask) break;
            mask <<= 1;
        }

        return res;
    }
}

package problems;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int indexG = 0;
        int indexS = 0;

        int res = 0;

        while(indexS < s.length && indexG < g.length) {
            if(s[indexS] >= g[indexG]) {
                res++;
                indexS++;
                indexG++;
            } else {
                indexS++;
            }
        }
        return res;
    }
}

package problems;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char ch: jewels.toCharArray()) set.add(ch);

        int result = 0;
        for(char ch: stones.toCharArray()) if(set.contains(ch)) result++;
        return result;
    }
}

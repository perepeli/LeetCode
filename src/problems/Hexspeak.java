package problems;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Hexspeak {
    private Map<Integer,Character> hex = new HashMap<Integer,Character>() {{
        put(0, 'O');
        put(1, 'I');
        put(10, 'A');
        put(11, 'B');
        put(12, 'C');
        put(13, 'D');
        put(14, 'E');
        put(15, 'F');
    }};

    public String toHexspeak(String num) {
        StringBuilder sb = new StringBuilder();
        Long copy = Long.parseLong(num);

        while (copy > 0) {
            int remainder = (int) (copy % 16);
            if (!hex.containsKey(remainder)) return "ERROR";
            else sb.append(hex.get(remainder));
            copy /= 16;
        }

        return sb.reverse().toString();
    }
}

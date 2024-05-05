package problems;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            encodedString.append(s.length()).append("/:").append(s);
        }
        return encodedString.toString();
    }

    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delim = s.indexOf("/:", i);
            int length = Integer.parseInt(s.substring(i, delim));
            String str = s.substring(delim + 2, delim + 2 + length);
            decodedStrings.add(str);
            i = delim + 2 + length;
        }
        return decodedStrings;
    }
}

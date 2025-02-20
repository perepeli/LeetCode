package problems;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');

        int index = 0;
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if(Character.isAlphabetic(c)) {
                if(!map.containsKey(c)) {
                    map.put(c, (char)(index + 'a'));
                    index++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            sb.append(map.get(message.charAt(i)));
        }

        return sb.toString();
    }
}

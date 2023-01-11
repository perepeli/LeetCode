package problems;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        Map<Character, ValueData> map = new HashMap<>();
        int firstUnique;

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.get(arr[i]).single = false;
            } else {
                map.put(arr[i], new ValueData(i));
            }
        }

        for(char c: arr) {
            if(map.get(c).single) return map.get(c).index;
        }
        return -1;
    }


    static class ValueData {
        public int index;
        public boolean single = true;

        public ValueData(int index) {
            this.index = index;
        }
    }
}

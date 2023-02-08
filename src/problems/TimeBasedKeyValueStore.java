package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            TreeMap<Integer, String> newValue = new TreeMap<>();
            newValue.put(timestamp, value);
            map.put(key, newValue);
        } else {
            map.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            Map.Entry<Integer, String> resultOrNull = map.get(key).floorEntry(timestamp);

            if(resultOrNull != null) {
                return resultOrNull.getValue();
            }
        }
        return "";
    }
}

package problems;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    Map<String, Integer> map = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            int oldTimestamp = map.get(message);

            if(timestamp  - oldTimestamp >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

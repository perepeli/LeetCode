package problems;

import java.util.*;

public class StockPriceFluctuation {
    Map<Integer, Integer> timestampValue;
    TreeMap<Integer, Set<Integer>> valueKeys;
    Integer latestTimestamp;

    public StockPriceFluctuation() {
        timestampValue = new HashMap<>();
        valueKeys = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if(latestTimestamp == null || latestTimestamp < timestamp) {
            latestTimestamp = timestamp;
        }

        if(timestampValue.containsKey(timestamp)) {
            int oldPrice = timestampValue.get(timestamp);
            valueKeys.get(oldPrice).remove(timestamp);
            if(valueKeys.get(oldPrice).isEmpty()) {
                valueKeys.remove(oldPrice);
            }
        }

        timestampValue.put(timestamp, price);
        if(!valueKeys.containsKey(price)) valueKeys.put(price, new HashSet<>());
        valueKeys.get(price).add(timestamp);
    }

    public int current() {
        return timestampValue.get(latestTimestamp);
    }

    public int maximum() {
        return valueKeys.lastKey();
    }

    public int minimum() {
        return valueKeys.firstKey();
    }
}

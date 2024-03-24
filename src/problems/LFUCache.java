package problems;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    Map<Integer, AbstractMap.SimpleEntry<Integer, Integer>> cache; // Key, Freq-Value
    Map<Integer, LinkedHashSet<Integer>> frequencies; // Freq, Set<Key>
    Integer minFrequency;

    int maxCapacity;
    int currCapacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        maxCapacity = capacity;
        currCapacity = 0;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        } else {
            AbstractMap.SimpleEntry<Integer, Integer> oldPair = cache.get(key);
            int oldFreq = oldPair.getKey();
            int newFreq = oldPair.getKey() + 1;

            cache.remove(key);
            cache.put(key, new AbstractMap.SimpleEntry<>(newFreq, oldPair.getValue()));

            frequencies.get(oldFreq).remove(key);
            if(!frequencies.containsKey(newFreq)) frequencies.put(newFreq, new LinkedHashSet<>());
            frequencies.get(newFreq).add(key);

            //
            if(frequencies.get(oldFreq).isEmpty()) {
                if(minFrequency == oldFreq) {
                    minFrequency = newFreq;
                }
            }

            return oldPair.getValue();
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) { // cache already has this key, update frequency, replace value
            int oldFreq = cache.get(key).getKey();
            int newFreq = oldFreq + 1;

            cache.remove(key);
            cache.put(key, new AbstractMap.SimpleEntry<>(newFreq, value));

            frequencies.get(oldFreq).remove(key);
            if(!frequencies.containsKey(newFreq)) frequencies.put(newFreq, new LinkedHashSet<>());
            frequencies.get(newFreq).add(key);

            if(frequencies.get(oldFreq).isEmpty()) {
                if(minFrequency == oldFreq) {
                    minFrequency = newFreq;
                }
            }

        } else {
            if(currCapacity == maxCapacity) { // cache is full
                // determine what to remove?
                int keyToRemove = frequencies.get(minFrequency).iterator().next();
                frequencies.get(minFrequency).iterator().remove();

                cache.remove(keyToRemove);

                cache.put(key, new AbstractMap.SimpleEntry<>(1, value));
                if(!frequencies.containsKey(1)) frequencies.put(1, new LinkedHashSet<>());
                frequencies.get(1).add(key);
            } else { // cache is not full
                cache.put(key, new AbstractMap.SimpleEntry<>(1, value));
                if(!frequencies.containsKey(1)) frequencies.put(1, new LinkedHashSet<>());
                frequencies.get(1).add(key);
                currCapacity++;
            }
            minFrequency = 1;
        }
    }
}

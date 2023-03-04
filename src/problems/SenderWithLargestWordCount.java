package problems;

import java.util.*;

public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();

        int topWords = Integer.MIN_VALUE;

        for(int i = 0; i < senders.length; i++) {
            String sender = senders[i];
            map.put(sender, map.getOrDefault(sender, 0) + wordCount(messages[i]));
            if(map.get(sender) > topWords) {
                topWords = map.get(sender);
            }
        }

        List<String> topSenders = new ArrayList<>();

        for(String key : map.keySet()) {
            if(map.get(key) == topWords) topSenders.add(key);
        }

        Collections.sort(topSenders, (s1, s2) -> s2.compareTo(s1));


        return topSenders.get(0);

    }

    private int wordCount(String message) {
        int spaceCount = 0;
        for(int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' ') spaceCount++;
        }
        return spaceCount + 1;
    }
}

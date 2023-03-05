package problems;

import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<AbstractMap.SimpleEntry<String, String>>> map = new HashMap<>();

        for(String s : paths) {
            String[] str = s.split(" ");

            for(int i = 1; i < str.length; i++) {
                int leftBracketIndex = str[i].indexOf('(');

                String fileName = str[i].substring(0, leftBracketIndex);
                String file = str[i].substring(leftBracketIndex);

                if(!map.containsKey(file)) {
                    List<AbstractMap.SimpleEntry<String, String>> newList = new ArrayList<>();
                    map.put(file, newList);
                }
                map.get(file).add(new AbstractMap.SimpleEntry<>(str[0], fileName));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(List<AbstractMap.SimpleEntry<String, String>> l : map.values()) {
            if(l.size() > 1) {
                List<String> list = new ArrayList<>();
                for(AbstractMap.SimpleEntry<String, String> p : l) {
                    list.add(p.getKey() + "/" + p.getValue());
                }
                result.add(list);
            }
        }

        return result;
    }
}

package problems;

import java.util.*;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        int index = 0;

        for(int i = index; i < order.length(); i++) {
            map.put(order.charAt(i), i);
            index++;
        }

        for(int i = index; i < 26; i++) {
            char ch = (char)(i + 'a');
            if(!map.containsKey(ch)) {
                map.put(ch, i);
            }
            index++;
        }


        char[] sorted = s.toCharArray();

        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) list.add(s.charAt(i));

        Collections.sort(list, Comparator.comparingInt(map::get));

        map.entrySet().forEach(System.out::println);

        StringBuilder res = new StringBuilder();
        list.forEach(e -> res.append(e));

        return res.toString();
    }
}

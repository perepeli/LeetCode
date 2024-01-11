package problems;

import java.util.ArrayDeque;
import java.util.Deque;

import problems.util.Pair;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        //if(words.length == 1) return words[0]; // corner case : aba -> invalid
        //abbc
        //abcd

        Deque<Pair<String, Integer>> queue = new ArrayDeque<>();

        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            String s = words[i];

            for(int j = 0; j < s.length(); j++) {
                if(j > 0 && s.charAt(j) == s.charAt(j - 1)) continue;
                sb.append(s.charAt(j));
            }
            queue.addLast(new Pair<>(sb.toString(), 0));
        }


        char prev = '*';

        while(!queue.isEmpty()) {
            Pair<String, Integer> p = queue.removeFirst();
            String s = p.getKey();
            int index = p.getValue();
            if(index >= s.length()) continue;

            Deque<Pair<String, Integer>> tmpStack = new ArrayDeque<>();

            while(!queue.isEmpty()) {
                char ch = queue.peekFirst().getKey().charAt(queue.peekFirst().getValue());
                if(queue.peekFirst().getKey().charAt(queue.peekFirst().getValue()) != s.charAt(index)) break;
                Pair<String, Integer> tmp = queue.removeFirst();
                tmpStack.addLast(new Pair<>(tmp.getKey(), tmp.getValue() + 1));
            }

            while (!tmpStack.isEmpty()) {
                queue.addFirst(tmpStack.removeLast());
            }
            System.out.println(prev + " -> " + s.charAt(index));

            prev = s.charAt(index);
        }
    }
}

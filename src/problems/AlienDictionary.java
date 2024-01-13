package problems;

import java.util.*;

import problems.util.Pair;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>(); // dependency to <set>dependant
        Map<Character, Integer> inDegree = new HashMap<>(); // dependant -> inDegree

        for(int i = 1; i < words.length; i++) {
            String dependant = words[i - 1];
            String dependency = words[i];

            int j = 0;

            while(j < dependant.length() && j < dependency.length()) {
                char dependantChar = dependant.charAt(j);
                char dependencyChar = dependency.charAt(j);

                if(dependantChar == dependencyChar && ((j == dependant.length() - 1 || j == dependency.length() - 1) && (dependant.length() > dependency.length()))) return "";

                if(!adjList.containsKey(dependantChar)) adjList.put(dependantChar, new HashSet<>());
                if(!adjList.containsKey(dependencyChar)) adjList.put(dependencyChar, new HashSet<>());

                if(!inDegree.containsKey(dependantChar)) inDegree.put(dependantChar, 0);
                if(!inDegree.containsKey(dependencyChar)) inDegree.put(dependencyChar, 0);

                if(dependantChar != dependencyChar) {
                    if(!adjList.get(dependencyChar).contains(dependantChar)) {
                        adjList.get(dependencyChar).add(dependantChar);
                        inDegree.put(dependantChar, inDegree.get(dependantChar) + 1);
                    }

                    break;
                }

                j++;
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for(Map.Entry<Character, Integer> e : inDegree.entrySet()) {
            if(e.getValue() == 0) {
                queue.offer(e.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            Character dependency = queue.poll();
            sb.append(dependency);

            for(Character dependant : adjList.get(dependency)) {
                inDegree.put(dependant, inDegree.get(dependant) - 1);
                if(inDegree.get(dependant) == 0) {
                    queue.offer(dependant);
                }
            }

        }

        for(Map.Entry<Character, Integer> e : inDegree.entrySet()) {
            if(e.getValue() != 0) {
                return "";
            }
        }

        Set<Character> allChars = new HashSet<>();
        for(String w : words) {
            for(int i = 0; i < w.length(); i++) allChars.add(w.charAt(i));
        }

        sb.reverse();

        for(Character c : allChars) {
            if(!adjList.containsKey(c)) sb.append(c);
        }

        return sb.toString();
    }
}

package problems;

import java.util.*;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Map<String, Set<String>> adjList = new HashMap<>();

        for(List<String> p : paths) {
            String source = p.get(0);
            String dest = p.get(1);

            if(!adjList.containsKey(source)) adjList.put(source, new HashSet<>());
            if(!adjList.containsKey(dest)) adjList.put(dest, new HashSet<>());

            adjList.get(source).add(dest);
        }

        for(Map.Entry<String, Set<String>> e : adjList.entrySet()) {
            if(e.getValue().size() == 0) return e.getKey();
        }
        return null;
    }
}

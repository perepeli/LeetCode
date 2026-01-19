import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) {

        Map<String, Set<String>> graph = Map.of(
                "A", Set.of("B", "C"),
                "B", Set.of("C"),
                "C", Set.of("D")
        );

        Map<String, Integer> indegree = new HashMap<>();

        for(var e : graph.entrySet()) {
            for(String child : e.getValue()) {
                indegree.put(child, indegree.getOrDefault(child, 0) + 1);
            }
        }

        indegree.put("A", 1);

        Map<String, Integer> load = new HashMap<>();

        load.put("A", 1);

        for(String parent : indegree.keySet()) {
            int parentLoad = load.get(parent);
            if(!graph.containsKey(parent)) continue;
            for(String child : graph.get(parent)) {
                load.put(child, load.getOrDefault(child, 0) + parentLoad);
            }
        }





        System.out.println(indegree);
        System.out.println(load);

    }
}





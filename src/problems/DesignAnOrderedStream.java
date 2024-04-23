package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignAnOrderedStream {
    private Map<Integer, String> map = new HashMap<>();
    private int pointer = 1;

    public DesignAnOrderedStream(int n) {}

    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);

        List<String> res = new ArrayList<>();

        while(map.containsKey(pointer)) {
            res.add(map.remove(pointer++));
        }

        return res;
    }
}

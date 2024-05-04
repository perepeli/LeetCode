package problems;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {

    private Map<String, Integer> paths;

    public DesignFileSystem() {
        paths = new HashMap<String, Integer>();
    }

    public boolean createPath(String path, int value) {
        if(path.isEmpty() || "/".equals(path) || paths.containsKey(path)) return false;

        int delimIndex = path.lastIndexOf("/");
        String parent = path.substring(0, delimIndex);

        if(parent.length() > 1 && !paths.containsKey(parent)) {
            return false;
        }

        paths.put(path, value);
        return true;
    }

    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}

package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DesignInMemoryFileSystem {
    static class File {
        boolean isFile = false;
        String content = "";
        HashMap<String, File> files = new HashMap<>();
    }

    File root;

    public DesignInMemoryFileSystem() {
        root = new File();
    }

    public List<String> ls(String p) {
        File file = root;
        List<String> files = new ArrayList<>();
        if(!p.equals("/")) {
            String[] path = p.split("/");
            for(int i = 1; i < path.length; i++) {
                file = file.files.get(path[i]);
            }
            if(file.isFile) {
                files.add(path[path.length - 1]);
                return files;
            }
        }
        List<String> res = new ArrayList<>(file.files.keySet());
        Collections.sort(res);
        return res;
    }

    public void mkdir(String p) {
        File file = root;
        String[] path = p.split("/");
        for(int i = 1; i < path.length; i++) {
            if(!file.files.containsKey(path[i])) file.files.put(path[i], new File());
            file = file.files.get(path[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File file = root;
        String[] path = filePath.split("/");
        for(int i = 1; i < path.length - 1; i++) {
            file = file.files.get(path[i]);
        }
        if(!file.files.containsKey(path[path.length - 1])) file.files.put(path[path.length - 1], new File());
        file = file.files.get(path[path.length - 1]);
        file.isFile = true;
        file.content = file.content + content;
    }

    public String readContentFromFile(String filePath) {
        File file = root;
        String[] path = filePath.split("/");
        for(int i = 1; i < path.length - 1; i++) {
            file = file.files.get(path[i]);
        }
        return file.files.get(path[path.length - 1]).content;
    }
}

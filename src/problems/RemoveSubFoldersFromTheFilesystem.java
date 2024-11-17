package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folders = new HashSet<>();
        for(String s : folder) folders.add(s);

        List<String> res = new ArrayList<>();

        for(String s : folder) {
            int lastSlashIndex = s.length() - 1;

            while(lastSlashIndex > 0) {
                while('/' != s.charAt(lastSlashIndex)) lastSlashIndex--;
                String parent = s.substring(0, lastSlashIndex);
                if(folders.contains(parent)) break;
                lastSlashIndex--;
            }

            if(lastSlashIndex <= 0) res.add(s);
        }

        return res;
    }
}

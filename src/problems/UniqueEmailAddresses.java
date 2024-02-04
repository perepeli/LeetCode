package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> map = new HashMap<>();

        for(String email : emails) {
            String[] tokens = email.split("@");
            String localName = tokens[0];
            String domainName = tokens[1];

            StringBuilder cleanedLocalName = new StringBuilder();
            for(int i = 0; i < localName.length(); i++) {
                char currentChar = localName.charAt(i);
                if(currentChar == '+') break;
                if(currentChar == '.') continue;
                cleanedLocalName.append(currentChar);
            }

            map.putIfAbsent(cleanedLocalName.toString(), new HashSet<>());
            map.get(cleanedLocalName.toString()).add(domainName);
        }

        int count = 0;

        for(Map.Entry<String, Set<String>> e : map.entrySet()) {
            count += e.getValue().size();
        }

        return count;
    }
}

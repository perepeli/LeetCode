package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for(String str : cpdomains) {
            String[] keyValue = str.split(" ");
            String[] subdomains = keyValue[1].split("\\.");

            String subdomain = "";

            for(int i = subdomains.length-1; i >= 0; i--) {
                if(i == subdomains.length-1) {
                    subdomain = subdomains[i] + subdomain;
                } else {
                    subdomain = subdomains[i] + "." + subdomain;
                }

                map.put(subdomain, map.getOrDefault(subdomain, 0) + Integer.parseInt(keyValue[0]));
            }
        }

        List<String> res = new ArrayList<>();
        map.entrySet().forEach(entry -> res.add(entry.getValue() + " " + entry.getKey()));

        return res;
    }
}

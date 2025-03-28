package problems;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        class Visit {
            String username;
            int timestamp;
            String website;

            Visit(String username, int timestamp, String website) {
                this.username = username;
                this.timestamp = timestamp;
                this.website = website;
            }
        }

        List<Visit> visits = new ArrayList<>();
        for(int i = 0; i < username.length; i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }

        visits.sort((a, b) -> a.timestamp - b.timestamp);

        Map<String, List<String>> userWebsiteMap = new HashMap<>();

        for(Visit visit : visits) {
            userWebsiteMap.putIfAbsent(visit.username, new ArrayList<>());
            userWebsiteMap.get(visit.username).add(visit.website);
        }


        Map<String, Set<String>> patternUserMap = new HashMap<>();

        for(String user : userWebsiteMap.keySet()) {
            List<String> sites = userWebsiteMap.get(user);
            int N = sites.size();
            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    for(int k = j + 1; k < N; k++) {
                        String pattern = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);
                        patternUserMap.putIfAbsent(pattern, new HashSet<>());
                        patternUserMap.get(pattern).add(user);
                    }
                }
            }
        }

        String result = "";
        int maxCount = 0;

        for(String pattern : patternUserMap.keySet()) {
            int count = patternUserMap.get(pattern).size();
            if(count > maxCount || (count == maxCount && pattern.compareTo(result) < 0)) {
                result = pattern;
                maxCount = count;
            }
        }

        return Arrays.asList(result.split(","));
    }
}

package problems;

import java.util.*;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        int numOfTeams = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();

        for(Character s : votes[0].toCharArray()) map.put(s, new int[numOfTeams]);

        for(int i = 0; i < votes.length; i++) {
            String s = votes[i];

            for(int j = 0; j < s.length(); j++) {
                map.get(s.charAt(j))[j]++;
            }
        }

        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (e1, e2) -> {
            for(int i = 0; i < e1.getValue().length; i++) {
                if(e1.getValue()[i] < e2.getValue()[i]) return 1;
                if(e1.getValue()[i] > e2.getValue()[i]) return -1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();

        list.forEach(e -> sb.append(e.getKey()));

        return sb.toString();
    }
}

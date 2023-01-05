package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountItemsMatchingTheRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> rules = new HashMap<>();
        rules.put("type", 0);
        rules.put("color", 1);
        rules.put("name", 2);

        int numToReturn = 0;

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).get(rules.get(ruleKey)).equals(ruleValue)) {
                numToReturn++;
            }
        }
        return numToReturn;
    }
}

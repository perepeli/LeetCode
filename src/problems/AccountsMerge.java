package problems;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Map<Integer, Set<String>>> map = new HashMap<>();

        for(List<String> list : accounts) {
            String name = list.get(0);
            if(!map.containsKey(name)) map.put(name, new HashMap<>());

            Map<Integer, Set<String>> mapForName = map.get(name);

            Set<Integer> accountsToInsert = new HashSet<>();
            Set<String> emailsToAdd = new HashSet<>();

            for(int i = 1; i < list.size(); i++) {
                String account = list.get(i);
                emailsToAdd.add(account);
                for(Map.Entry<Integer, Set<String>> e : mapForName.entrySet()) {
                    if(e.getValue().contains(account)) {
                        accountsToInsert.add(e.getKey());
                    }
                }
            }

            if(accountsToInsert.size() == 0) {
                int newIndex = 1;
                while(mapForName.containsKey(newIndex)) newIndex++;
                mapForName.put(newIndex, emailsToAdd);
            } else {
                List<Integer> toMerge = new ArrayList<>(accountsToInsert);
                Collections.sort(toMerge, (a1, a2) -> mapForName.get(a1).size() - mapForName.get(a2).size());
                int mainAccountIndex = toMerge.get(0);

                // merge everything to main account
                for(int i = 1; i < toMerge.size(); i++) {
                    int accountIndex = toMerge.get(i);
                    mapForName.get(mainAccountIndex).addAll(mapForName.get(accountIndex));
                    mapForName.remove(accountIndex);
                }
                // add all from new account
                mapForName.get(mainAccountIndex).addAll(emailsToAdd);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String, Map<Integer, Set<String>>> e : map.entrySet()) {
            //System.out.println(e.getKey() + " : -> : " + e.getValue().size());
            Map<Integer, Set<String>> accs = map.get(e.getKey());

            for(Set<String> acc : accs.values()) {
                List<String> sorted = new ArrayList<>();
                sorted.addAll(acc);
                Collections.sort(sorted);
                sorted.add(0, e.getKey());
                res.add(sorted);
            }
        }

        return res;
    }
}

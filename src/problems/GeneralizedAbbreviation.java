package problems;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backtrack(word, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String word, int index, List<Object> temp, List<String> res) {
        if(index == word.length()) {
            StringBuilder sb = new StringBuilder();
            for(Object o : temp) sb.append(o);
            res.add(sb.toString());
            return;
        } else {
            temp.add(word.charAt(index));
            backtrack(word, index + 1, temp, res);
            temp.remove(temp.size() - 1);

            if(temp.size() > 0 && temp.get(temp.size() - 1) instanceof Integer) {
                temp.add(((int)temp.remove(temp.size() - 1)) + 1);
                backtrack(word, index + 1, temp, res);
            } else {
                temp.add(1);
                backtrack(word, index + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

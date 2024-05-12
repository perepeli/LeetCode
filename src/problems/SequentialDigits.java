package problems;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String pattern = "123456789";

        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        for(int i = lowLength; i <= highLength; i++) {
            int left = 0;
            int right = i - 1;
            while(right < pattern.length()) {
                String numString = pattern.substring(left, right + 1);
                int num = Integer.parseInt(numString);
                if(num >= low && num <= high) res.add(num);
                left++;
                right++;
            }
        }

        return res;
    }
}

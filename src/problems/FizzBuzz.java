package problems;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            String result = "";
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            if(divisibleBy3) result += "Fizz";
            if(divisibleBy5) result += "Buzz";
            if("".equals(result)) result += Integer.toString(i);

            list.add(result);
        }

        return list;
    }
}

package problems;

import java.util.Arrays;

public class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details)
                .map(str ->  (str.charAt(12) - 48) + 10 * (str.charAt(11) - 48))
                .filter(age -> age > 60)
                .count();
    }
}

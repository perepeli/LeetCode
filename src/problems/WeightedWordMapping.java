package problems;

public class WeightedWordMapping {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String s : words) {
            int weight = 0;

            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                weight += weights[index];
            }

            char c = (char)((weight % 26));
            char reversed = (char)('z' - c);

            sb.append(reversed);
        }


        return sb.toString();
    }
}

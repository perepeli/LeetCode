package problems;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        while(k > 0 && index < s.length()) {
            if(index < s.length() && Character.isWhitespace(s.charAt(index))) {
                sb.append(' ');
                while(index < s.length() && Character.isWhitespace(s.charAt(index))) index++;
            }

            while(index < s.length() && !Character.isWhitespace(s.charAt(index))) {
                sb.append(s.charAt(index));
                index++;
            }
            k--;
        }

        return sb.toString();
    }
}

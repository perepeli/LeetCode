package problems;

public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && s.charAt(i) != s.charAt(i - 1)) count = 0;
            count++;

            if(count < 3) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

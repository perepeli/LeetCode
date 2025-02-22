package problems;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int longest = str.length();

        for(String s : strs) {
            int temp = 0;
            for(int i = 0; i < s.length(); i++) {
                if(i >= str.length() || str.charAt(i) != s.charAt(i)) break;
                temp++;
            }

            longest = Math.min(longest, temp);
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < longest; i++) {
            result.append(str.charAt(i));
        }


        return result.toString();
    }
}

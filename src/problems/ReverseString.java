package problems;

public class ReverseString {
    public void reverseString(char[] s) {
        helper(0, s.length-1, s);
    }

    private void helper(int first, int last, char[] str) {
        if(first >= last) return;

        char temp = str[first];
        str[first] = str[last];
        str[last] = temp;

        helper(first+1, last-1, str);
    }
}

package problems;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, width = 0;
        for (char c: s.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }

        return new int[]{lines, width};
    }
}

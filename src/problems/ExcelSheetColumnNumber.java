package problems;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;

        int power = 0;

        for(int i = columnTitle.length() - 1; i >= 0; i--) {
            int x = (int)(columnTitle.charAt(i) - 'A') + 1;
            res += ((int)Math.pow(26, power)) * x;
            power++;
        }


        return res;
    }
}

package problems;

public class Base7 {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder res = new StringBuilder();

        int base = 7;

        while(num > 0) {
            int digit = num % base;
            res.append(digit);
            num /= base;
        }

        if(negative) res.append('-');

        return res.reverse().toString();
    }
}

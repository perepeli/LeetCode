package problems;

public class MinimumChangesToMakeAlternatinBinaryString {
    public int minOperations(String s) {
        int res = s.length();

        int temp = 0;

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) == '0' ? 0 : 1;

            if(i % 2 == c) continue;
            temp++;
        }

        res = Math.min(res, temp);

        temp = 0;

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) == '1' ? 0 : 1;

            if(i % 2 == c) continue;
            temp++;
        }

        res = Math.min(res, temp);

        return res;
    }
}

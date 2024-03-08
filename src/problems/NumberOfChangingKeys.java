package problems;

public class NumberOfChangingKeys {

    public int countKeyChanges(String s) {
        int counter = 0;

        for(int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i);
            int prev = s.charAt(i - 1);

            if(curr == prev) continue;
            if(curr == prev + 32) continue;
            if(curr + 32 == prev) continue;

            counter++;
        }

        return counter;
    }
}

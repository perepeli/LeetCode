package problems;

public class FirstUniqueEvenElement {
    public int firstUniqueEven(int[] nums) {
        int[] freq = new int[100];
        for(int i : nums) {
            freq[i - 1] ++;
        }

        for(int i : nums) {
            if(i % 2 == 0 && freq[i - 1] == 1) {
                return i;
            }
        }

        return -1;
    }
}

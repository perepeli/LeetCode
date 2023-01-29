package problems;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        int shift = 1;

        for(int i = 32; i >= 1; i--) {
            if(!((n & shift) == 0)) bits++;
            shift += shift;
        }
        return bits;
    }
}
